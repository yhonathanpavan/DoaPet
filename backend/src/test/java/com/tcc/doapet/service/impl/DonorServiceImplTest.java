package com.tcc.doapet.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
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

import java.util.Arrays;
import java.util.Optional;

import static com.tcc.doapet.builder.DonorBuilder.*;
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
    void getAll() throws JsonProcessingException {
        when(donorRepository.findAll(any(Pageable.class))).thenReturn(new PageImpl<>(Arrays.stream(getDonorArray()).toList()));

        var actualDonorResponse = donorService.getAll(PageRequest.of(0, 10));

        assertNotNull(actualDonorResponse.getContent());
        assertEquals(2, actualDonorResponse.getContent().size());
        assertEquals(getDonorArray()[0].getName(), actualDonorResponse.getContent().get(0).getName());
    }

    @Test
    void getById() throws JsonProcessingException{
        when(donorRepository.findById(anyLong())).thenReturn(Optional.of(getDonor()));

        var actualDonorResponse = donorService.getById(1L);

        assertNotNull(actualDonorResponse);
        assertTrue(actualDonorResponse.getActive());
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
    void updateById() throws JsonProcessingException {
        when(donorRepository.findById(anyLong())).thenReturn(Optional.of(getDonor()));
        when(donorRepository.save(any())).thenReturn(getDonor());

        var actualDonorResponse = donorService.updateById(1L, getDonorRequest());

        assertNotNull(actualDonorResponse);
        verify(donorRepository, times(1)).save(any());
    }

}