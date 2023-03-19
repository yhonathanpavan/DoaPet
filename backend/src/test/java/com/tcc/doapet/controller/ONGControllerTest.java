package com.tcc.doapet.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tcc.doapet.service.ONGService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import static com.tcc.doapet.factory.ONGFactory.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ONGControllerTest {

    @InjectMocks
    private ONGController ongController;

    @Mock
    private ONGService ongService;

    @Test
    void getAll() throws JsonProcessingException {
        when(ongService.getAll(any(Pageable.class))).thenReturn(getPageableONGResponse());

        Pageable pageable = PageRequest.of(0, 10);
        var ongActualResponse = ongController.getAll(pageable);

        assertNotNull(ongActualResponse.getBody());
        assertEquals(HttpStatus.OK, ongActualResponse.getStatusCode());

        assertEquals(getPageableONGResponse().getContent().get(0).getName(),
                     ongActualResponse.getBody().getContent().get(0).getName());
    }

    @Test
    void getById() throws JsonProcessingException {
        when(ongService.getById(anyLong())).thenReturn(getONGResponse());

        var ongActualResponse = ongController.create(1L);


        assertNotNull(ongActualResponse.getBody());
        assertEquals(HttpStatus.OK, ongActualResponse.getStatusCode());

        assertEquals(getONGResponse().getName(), ongActualResponse.getBody().getName());
    }

    @Test
    void create() throws JsonProcessingException {
        var uri = ServletUriComponentsBuilder.fromPath("/doapet/v1/ONGs/{id}").build(1L);
        when(ongService.create(any())).thenReturn(uri);

        var ongActualResponse = ongController.create(getONGRequest());

        assertEquals(HttpStatus.CREATED, ongActualResponse.getStatusCode());
        assertNotNull(ongActualResponse.getHeaders().getLocation());
        assertEquals(ongActualResponse.getHeaders().getLocation(), uri);
    }

    @Test
    void updateById() throws JsonProcessingException {
        when(ongService.updateById(anyLong(), any())).thenReturn(getONGResponse());

        var ongActualResponse = ongController.updateById(1L, getONGRequest());

        assertEquals(HttpStatus.OK, ongActualResponse.getStatusCode());
        assertNotNull(ongActualResponse.getBody());
        assertEquals(ongActualResponse.getBody().getId(), getONGResponse().getId());
    }
}