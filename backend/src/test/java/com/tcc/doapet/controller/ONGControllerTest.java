package com.tcc.doapet.controller;

import com.tcc.doapet.model.enums.PriorityLevelStatus;
import com.tcc.doapet.service.ONGService;
import com.tcc.doapet.service.OrderService;
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

import static com.tcc.doapet.factory.ONGFactory.*;
import static com.tcc.doapet.factory.OrderFactory.getOrderProductResponse;
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

    @Mock
    private OrderService orderService;

    private final String authorization = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJEb2FQZXQgQXBwbGljYXRpb24iLCJzdWIiOiIxIiwiaWF0IjoxNjgxNjkyOTU3LCJleHAiOjE2ODE2OTY1NTcsImNsYXNzVHlwZSI6Ik9ORyJ9.WEY92AEX61C8UsIcDX4_aHZLIrfB6gmiQtIm50pDG34";

    @Test
    void getAll(){
        when(ongService.getAll(any(Pageable.class))).thenReturn(getPageableONGResponse());

        Pageable pageable = PageRequest.of(0, 10);
        var ongActualResponse = ongController.getAll(pageable);

        assertNotNull(ongActualResponse.getBody());
        assertEquals(HttpStatus.OK, ongActualResponse.getStatusCode());

        assertEquals(getPageableONGResponse().getContent().get(0).getName(),
                     ongActualResponse.getBody().getContent().get(0).getName());
    }

    @Test
    void getById(){
        when(ongService.getById(anyLong())).thenReturn(getONGResponse());

        var ongActualResponse = ongController.getById(1L);


        assertNotNull(ongActualResponse.getBody());
        assertEquals(HttpStatus.OK, ongActualResponse.getStatusCode());

        assertEquals(getONGResponse().getName(), ongActualResponse.getBody().getName());
    }

    @Test
    void getPrioritiesLevelStatus(){
        when(orderService.getPrioritiesLevelStatus()).thenReturn(List.of(PriorityLevelStatus.values()));

        var assistanceActualResponse = ongController.getPrioritiesLevelStatus();

        assertNotNull(assistanceActualResponse.getBody());
        assertEquals(HttpStatus.OK, assistanceActualResponse.getStatusCode());
    }

    @Test
    void create(){
        var uri = ServletUriComponentsBuilder.fromPath("/doapet/v1/ONGs/{id}").build(1L);
        when(ongService.create(any())).thenReturn(uri);

        var ongActualResponse = ongController.create(getONGRequest());

        assertEquals(HttpStatus.CREATED, ongActualResponse.getStatusCode());
        assertNotNull(ongActualResponse.getHeaders().getLocation());
        assertEquals(ongActualResponse.getHeaders().getLocation(), uri);
    }

    @Test
    void updateById() {
        when(ongService.updateById(anyLong(), any())).thenReturn(getONGResponse());

        var ongActualResponse = ongController.updateById(1L, getONGRequest(), authorization);

        assertEquals(HttpStatus.OK, ongActualResponse.getStatusCode());
        assertNotNull(ongActualResponse.getBody());
        assertEquals(ongActualResponse.getBody().getId(), getONGResponse().getId());
    }

    @Test
    void updateStatus_WhenSendONGId_ExpectedResponseEntityONGResponse() {
        when(ongService.updateStatus(anyLong())).thenReturn(getONGResponse());

        var ongActualResponse = ongController.updateStatus(1L, authorization);

        assertEquals(HttpStatus.OK, ongActualResponse.getStatusCode());
        assertNotNull(ongActualResponse.getBody());
    }

    @Test
    void cancelOrder_WhenSendONGIdAndOrderId_ExpectedOK() {
        when(orderService.cancelOrder(anyLong(), anyLong())).thenReturn(getOrderProductResponse());

        var response = ongController.cancelOrder(1L, 1L, authorization);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }
}