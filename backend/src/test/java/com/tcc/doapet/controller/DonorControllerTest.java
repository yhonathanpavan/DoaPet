package com.tcc.doapet.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tcc.doapet.service.DonorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import static com.tcc.doapet.builder.DonorBuilder.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DonorControllerTest {

    @InjectMocks
    private DonorController donorController;

    @Mock
    private DonorService donorService;

    @Test
    void getAll() throws JsonProcessingException {
        when(donorService.getAll(any(Pageable.class))).thenReturn(getPageableDonorResponse());

        Pageable pageable = PageRequest.of(0, 10);
        var donorActualResponse = donorController.getAll(pageable);

        assertNotNull(donorActualResponse.getBody());
        assertEquals(HttpStatus.OK, donorActualResponse.getStatusCode());

        assertEquals(getPageableDonorResponse().getContent().get(0).getName(),
                     donorActualResponse.getBody().getContent().get(0).getName());
    }

    @Test
    void getById() throws JsonProcessingException {
        when(donorService.getById(anyLong())).thenReturn(getDonorResponse());

        var donorActualResponse = donorController.create(1L);


        assertNotNull(donorActualResponse.getBody());
        assertEquals(HttpStatus.OK, donorActualResponse.getStatusCode());

        assertEquals(getDonorResponse().getName(), donorActualResponse.getBody().getName());
    }

    @Test
    void create() throws JsonProcessingException {
        var uri = ServletUriComponentsBuilder.fromPath("/doapet/v1/Donors/{id}").build(1L);
        when(donorService.create(any())).thenReturn(uri);

        var donorActualResponse = donorController.create(getDonorRequest());

        assertEquals(HttpStatus.CREATED, donorActualResponse.getStatusCode());
        assertNotNull(donorActualResponse.getHeaders().getLocation());
        assertEquals(donorActualResponse.getHeaders().getLocation(), uri);
    }

    @Test
    void updateById() throws JsonProcessingException {
        when(donorService.updateById(anyLong(), any())).thenReturn(getDonorResponse());

        var donorActualResponse = donorController.updateById(1L, getDonorRequest());

        assertEquals(HttpStatus.OK, donorActualResponse.getStatusCode());
        assertNotNull(donorActualResponse.getBody());
        assertEquals(donorActualResponse.getBody().getId(), getDonorResponse().getId());
    }
}