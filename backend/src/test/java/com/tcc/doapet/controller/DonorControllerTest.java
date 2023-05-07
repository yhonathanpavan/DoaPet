package com.tcc.doapet.controller;

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

import static com.tcc.doapet.factory.DonorFactory.*;
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

    private final String authorization = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJEb2FQZXQgQXBwbGljYXRpb24iLCJzdWIiOiIxIiwiaWF0IjoxNjgxNjkyOTg2LCJleHAiOjE2ODE2OTY1ODYsImNsYXNzVHlwZSI6IkRPTk9SIn0.xkg_0ZycUof3n6Gbd2zbvM0S4SYToUlA5pmFg1gqyRM";


    @Test
    void getAll(){
        when(donorService.getAll(any(Pageable.class))).thenReturn(getPageableDonorResponse());

        Pageable pageable = PageRequest.of(0, 10);
        var donorActualResponse = donorController.getAll(pageable);

        assertNotNull(donorActualResponse.getBody());
        assertEquals(HttpStatus.OK, donorActualResponse.getStatusCode());

        assertEquals(getPageableDonorResponse().getContent().get(0).getName(),
                     donorActualResponse.getBody().getContent().get(0).getName());
    }

    @Test
    void getById(){
        when(donorService.getById(anyLong())).thenReturn(getDonorResponse());

        var donorActualResponse = donorController.getById(1L, authorization);


        assertNotNull(donorActualResponse.getBody());
        assertEquals(HttpStatus.OK, donorActualResponse.getStatusCode());

        assertEquals(getDonorResponse().getName(), donorActualResponse.getBody().getName());
    }

    @Test
    void create(){
        var uri = ServletUriComponentsBuilder.fromPath("/doapet/v1/Donors/{id}").build(1L);
        when(donorService.create(any())).thenReturn(uri);

        var donorActualResponse = donorController.create(getDonorRequest());

        assertEquals(HttpStatus.CREATED, donorActualResponse.getStatusCode());
        assertNotNull(donorActualResponse.getHeaders().getLocation());
        assertEquals(donorActualResponse.getHeaders().getLocation(), uri);
    }

    @Test
    void updateById(){
        when(donorService.updateById(anyLong(), any())).thenReturn(getDonorResponse());

        var donorActualResponse = donorController.updateById(1L, getDonorRequest(), authorization);

        assertEquals(HttpStatus.OK, donorActualResponse.getStatusCode());
        assertNotNull(donorActualResponse.getBody());
        assertEquals(donorActualResponse.getBody().getId(), getDonorResponse().getId());
    }

    @Test
    void updateStatus_WhenSendDonorId_ExpectedResponseEntityDonorResponse() {
        when(donorService.updateStatus(anyLong())).thenReturn(getDonorResponse());

        var donorActualResponse = donorController.updateStatus(1L, authorization);

        assertEquals(HttpStatus.OK, donorActualResponse.getStatusCode());
        assertNotNull(donorActualResponse.getBody());
    }
}