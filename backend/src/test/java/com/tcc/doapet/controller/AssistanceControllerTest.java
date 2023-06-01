package com.tcc.doapet.controller;

import com.tcc.doapet.model.enums.AssistanceCategory;
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

import java.util.List;

import static com.tcc.doapet.factory.AssistanceFactory.*;
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

    private final String authorization = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJEb2FQZXQgQXBwbGljYXRpb24iLCJzdWIiOiIxIiwiaWF0IjoxNjgxNjkyOTg2LCJleHAiOjE2ODE2OTY1ODYsImNsYXNzVHlwZSI6IkRPTk9SIn0.xkg_0ZycUof3n6Gbd2zbvM0S4SYToUlA5pmFg1gqyRM";

    @Test
    void getAll(){
        when(assistanceService.getAll(any(Pageable.class), any())).thenReturn(getPageableAssistanceResponse());

        Pageable pageable = PageRequest.of(0, 10);
        var assistanceActualResponse = assistanceController.getAll(pageable, authorization);

        assertNotNull(assistanceActualResponse.getBody());
        assertEquals(HttpStatus.OK, assistanceActualResponse.getStatusCode());

        assertEquals(getPageableAssistanceResponse().getContent().get(0).getName(),
                     assistanceActualResponse.getBody().getContent().get(0).getName());
    }

    @Test
    void getById(){
        when(assistanceService.getById(anyLong(), any())).thenReturn(getAssistanceResponse());

        var assistanceActualResponse = assistanceController.getById(1L, authorization);


        assertNotNull(assistanceActualResponse.getBody());
        assertEquals(HttpStatus.OK, assistanceActualResponse.getStatusCode());

        assertEquals(getAssistanceResponse().getName(), assistanceActualResponse.getBody().getName());
    }

    @Test
    void getAssistanceCategories(){
        when(assistanceService.getAssistanceCategories()).thenReturn(List.of(AssistanceCategory.values()));

        var assistanceActualResponse = assistanceController.getAssistanceCategories();

        assertNotNull(assistanceActualResponse.getBody());
        assertEquals(HttpStatus.OK, assistanceActualResponse.getStatusCode());
    }

    @Test
    void create(){
        var uri = ServletUriComponentsBuilder.fromPath("/doapet/v1/assistances/{id}").build(1L);
        when(assistanceService.create(any(), any())).thenReturn(uri);

        var assistanceActualResponse = assistanceController.create(getAssistanceRequest(), authorization);

        assertEquals(HttpStatus.CREATED, assistanceActualResponse.getStatusCode());
        assertNotNull(assistanceActualResponse.getHeaders().getLocation());
        assertEquals(assistanceActualResponse.getHeaders().getLocation(), uri);
    }

    @Test
    void updateById(){
        when(assistanceService.updateById(anyLong(), any(), any())).thenReturn(getAssistanceResponse());

        var assistanceActualResponse = assistanceController.updateById(1L, getAssistanceRequest(), authorization);

        assertEquals(HttpStatus.OK, assistanceActualResponse.getStatusCode());
        assertNotNull(assistanceActualResponse.getBody());
        assertEquals(assistanceActualResponse.getBody().getId(), getAssistanceResponse().getId());
    }

    @Test
    void updateStatus_WhenSendAssistanceId_ExpectedAssistanceResponse(){
        when(assistanceService.updateStatus(anyLong(), any())).thenReturn(getAssistanceResponse());

        var assistanceActualResponse = assistanceController.updateStatus(1L, authorization);

        assertEquals(HttpStatus.OK, assistanceActualResponse.getStatusCode());
    }
}