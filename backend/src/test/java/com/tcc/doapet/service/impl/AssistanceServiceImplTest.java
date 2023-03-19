package com.tcc.doapet.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tcc.doapet.repository.AssistanceRepository;
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

import static com.tcc.doapet.factory.AssistanceFactory.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AssistanceServiceImplTest {

    @InjectMocks
    private AssistanceServiceImpl assistanceService;

    @Mock(answer = Answers.RETURNS_SMART_NULLS)
    private AssistanceRepository assistanceRepository;

    @Spy
    private ModelMapper modelMapper;

    @Test
    void getAll() throws JsonProcessingException {
        when(assistanceRepository.findAll(any(Pageable.class))).thenReturn(new PageImpl<>(getAssistanceArray()));

        var actualAssistanceResponse = assistanceService.getAll(PageRequest.of(0, 10));

        assertNotNull(actualAssistanceResponse.getContent());
        assertEquals(2, actualAssistanceResponse.getContent().size());
        assertEquals(getAssistanceArray().get(0).getName(), actualAssistanceResponse.getContent().get(0).getName());
    }

    @Test
    void getById() throws JsonProcessingException{
        when(assistanceRepository.findById(anyLong())).thenReturn(Optional.of(getAssistance()));

        var actualAssistanceResponse = assistanceService.getById(1L);

        assertNotNull(actualAssistanceResponse);
        assertTrue(actualAssistanceResponse.isActive());
        assertEquals(getAssistanceResponse().getId(), actualAssistanceResponse.getId());
        assertEquals(getAssistanceResponse().getName(), actualAssistanceResponse.getName());
        assertEquals(getAssistanceResponse().getAssistanceCategory(), actualAssistanceResponse.getAssistanceCategory());
        assertEquals(getAssistanceResponse().getPriorityLevelStatus(), actualAssistanceResponse.getPriorityLevelStatus());
    }

    @Test
    void create() throws JsonProcessingException{
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        when(assistanceRepository.save(any())).thenReturn(getAssistance());

        var actualAssistanceResponse = assistanceService.create(getAssistanceRequest());

        assertNotNull(actualAssistanceResponse);
        verify(assistanceRepository, times(1)).save(any());
    }

    @Test
    void updateById() throws JsonProcessingException {
        when(assistanceRepository.findById(anyLong())).thenReturn(Optional.of(getAssistance()));
        when(assistanceRepository.save(any())).thenReturn(getAssistance());

        var actualAssistanceResponse = assistanceService.updateById(1L, getAssistanceRequest());

        assertNotNull(actualAssistanceResponse);
        verify(assistanceRepository, times(1)).save(any());
    }

}