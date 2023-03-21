package com.tcc.doapet.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tcc.doapet.factory.ProductFactory;
import com.tcc.doapet.model.dto.response.DonorResponse;
import com.tcc.doapet.model.dto.response.ProductResponse;
import com.tcc.doapet.model.entity.Donor;
import com.tcc.doapet.model.entity.Product;
import com.tcc.doapet.repository.DonorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Optional;

import static com.tcc.doapet.factory.DonorFactory.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DonorServiceImplTest {

    @InjectMocks
    private DonorServiceImpl donorService;

    @Mock(answer = Answers.RETURNS_SMART_NULLS)
    private DonorRepository donorRepository;

    @Spy
    private ModelMapper modelMapper;

    @Test
    void getAll(){
        when(donorRepository.findAll(any(Pageable.class))).thenReturn(new PageImpl<>(getDonorArray()));

        var actualDonorResponse = donorService.getAll(PageRequest.of(0, 10));

        assertNotNull(actualDonorResponse.getContent());
        assertEquals(2, actualDonorResponse.getContent().size());
        assertEquals(getDonorArray().get(0).getName(), actualDonorResponse.getContent().get(0).getName());
    }

    @Test
    void getById() throws JsonProcessingException{
        when(donorRepository.findById(anyLong())).thenReturn(Optional.of(getDonor()));

        var actualDonorResponse = donorService.getById(1L);

        assertNotNull(actualDonorResponse);
        assertTrue(actualDonorResponse.getStatus());
        assertEquals(getDonorResponse().getId(), actualDonorResponse.getId());
        assertEquals(getDonorResponse().getName(), actualDonorResponse.getName());
        assertEquals(getDonorResponse().getCpf(), actualDonorResponse.getCpf());
        assertEquals(getDonorResponse().getEmail(), actualDonorResponse.getEmail());
    }

    @Test
    void create() throws JsonProcessingException{
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        when(donorRepository.save(any())).thenReturn(getDonor());

        var actualDonorResponse = donorService.create(getDonorRequest());

        assertNotNull(actualDonorResponse);
        verify(donorRepository, times(1)).save(any());
    }

    @Test
    void updateById(){
        when(donorRepository.findById(anyLong())).thenReturn(Optional.of(getDonor()));
        when(donorRepository.save(any())).thenReturn(getDonor());

        var actualDonorResponse = donorService.updateById(1L, getDonorRequest());

        assertNotNull(actualDonorResponse);
        verify(donorRepository, times(1)).save(any());
    }

    @Test
    void updateStatus_WhenSendDonorId_ExpectedDonorResponse() {
        when(donorRepository.findById(anyLong())).thenReturn(Optional.of(getDonor()));
        when(donorRepository.save(any())).thenReturn(getDonor());

        var response = donorService.updateStatus(1L);

        assertNotNull(response);
        assertEquals(DonorResponse.class, response.getClass());
        assertEquals(getDonor().getName(), response.getName());
        assertEquals(Boolean.TRUE, response.getStatus());
    }

    @Test
    void findDonorById_WhenSendDonorId_ExpectedDonor(){
        when(donorRepository.findById(anyLong())).thenReturn(Optional.of(getDonor()));

        var response = donorService.findDonorById(1L);

        assertNotNull(response);
        assertEquals(Donor.class, response.getClass());
        assertEquals(getDonor().getName(), response.getName());
        assertEquals(Boolean.TRUE, response.getStatus());
    }

}