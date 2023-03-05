package com.tcc.doapet.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tcc.doapet.repository.ONGRepository;
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

import static com.tcc.doapet.builder.ONGBuilder.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ONGServiceImplTest {

    @InjectMocks
    private ONGServiceImpl ongService;

    @Mock(answer = Answers.RETURNS_SMART_NULLS)
    private ONGRepository ongRepository;

    @Spy
    private ModelMapper modelMapper;

    @Test
    void getAll() throws JsonProcessingException {
        when(ongRepository.findAll(any(Pageable.class))).thenReturn(new PageImpl<>(Arrays.stream(getONGArray()).toList()));

        var actualONGResponse = ongService.getAll(PageRequest.of(0, 10));

        assertNotNull(actualONGResponse.getContent());
        assertEquals(2, actualONGResponse.getContent().size());
        assertEquals(getONGArray()[0].getName(), actualONGResponse.getContent().get(0).getName());
    }

    @Test
    void getById() throws JsonProcessingException{
        when(ongRepository.findById(anyLong())).thenReturn(Optional.of(getONG()));

        var actualONGResponse = ongService.getById(1L);

        assertNotNull(actualONGResponse);
        assertTrue(actualONGResponse.getActive());
        assertEquals(getONGResponse().getId(), actualONGResponse.getId());
        assertEquals(getONGResponse().getName(), actualONGResponse.getName());
        assertEquals(getONGResponse().getCnpj(), actualONGResponse.getCnpj());
        assertEquals(getONGResponse().getEmail(), actualONGResponse.getEmail());
    }

    @Test
    void create() throws JsonProcessingException{
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        when(ongRepository.save(any())).thenReturn(getONG());

        var actualONGResponse = ongService.create(getONGRequest());

        assertNotNull(actualONGResponse);
        verify(ongRepository, times(1)).save(any());
    }

    @Test
    void updateById() throws JsonProcessingException {
        when(ongRepository.findById(anyLong())).thenReturn(Optional.of(getONG()));
        when(ongRepository.save(any())).thenReturn(getONG());

        var actualONGResponse = ongService.updateById(1L, getONGRequest());

        assertNotNull(actualONGResponse);
        verify(ongRepository, times(1)).save(any());
    }

}