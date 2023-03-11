package com.tcc.doapet.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tcc.doapet.service.AssistanceService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import static com.tcc.doapet.builder.AssistanceBuilder.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AssistanceControllerTest {

    @InjectMocks
    private AssistanceController assistanceController;

    @Mock
    private AssistanceService assistanceService;

    @Test
    void getAll() throws JsonProcessingException {
        when(assistanceService.getAll(any(Pageable.class))).thenReturn(getPageableAssistanceResponse());

        Pageable pageable = PageRequest.of(0, 10);
        var assistanceActualResponse = assistanceController.getAll(pageable);

        assertNotNull(assistanceActualResponse.getBody());
        assertEquals(HttpStatus.OK, assistanceActualResponse.getStatusCode());

        assertEquals(getPageableAssistanceResponse().getContent().get(0).getName(),
                     assistanceActualResponse.getBody().getContent().get(0).getName());
    }

    @Test
    void getById() throws JsonProcessingException {
        when(assistanceService.getById(anyLong())).thenReturn(getAssistanceResponse());

        var assistanceActualResponse = assistanceController.create(1L);


        assertNotNull(assistanceActualResponse.getBody());
        assertEquals(HttpStatus.OK, assistanceActualResponse.getStatusCode());

        assertEquals(getAssistanceResponse().getName(), assistanceActualResponse.getBody().getName());
    }

    @Test
    void create() throws JsonProcessingException {
        var uri = ServletUriComponentsBuilder.fromPath("/doapet/v1/assistances/{id}").build(1L);
        when(assistanceService.create(any())).thenReturn(uri);

        var assistanceActualResponse = assistanceController.create(getAssistanceRequest());

        assertEquals(HttpStatus.CREATED, assistanceActualResponse.getStatusCode());
        assertNotNull(assistanceActualResponse.getHeaders().getLocation());
        assertEquals(assistanceActualResponse.getHeaders().getLocation(), uri);
    }

    @Test
    void updateById() throws JsonProcessingException {
        when(assistanceService.updateById(anyLong(), any())).thenReturn(getAssistanceResponse());

        var assistanceActualResponse = assistanceController.updateById(1L, getAssistanceRequest());

        assertEquals(HttpStatus.OK, assistanceActualResponse.getStatusCode());
        assertNotNull(assistanceActualResponse.getBody());
        assertEquals(assistanceActualResponse.getBody().getId(), getAssistanceResponse().getId());
    }
}