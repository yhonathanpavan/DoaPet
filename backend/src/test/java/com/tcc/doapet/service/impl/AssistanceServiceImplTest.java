package com.tcc.doapet.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tcc.doapet.factory.ONGFactory;
import com.tcc.doapet.model.dto.response.AssistanceResponse;
import com.tcc.doapet.model.entity.Assistance;
import com.tcc.doapet.model.enums.AssistanceCategory;
import com.tcc.doapet.repository.AssistanceRepository;
import com.tcc.doapet.repository.ONGRepository;
import com.tcc.doapet.service.TokenService;
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

import java.util.List;
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

    @Mock
    private TokenService tokenService;

    @Mock(answer = Answers.RETURNS_SMART_NULLS)
    private ONGRepository ongRepository;

    @Mock(answer = Answers.RETURNS_SMART_NULLS)
    private AssistanceRepository assistanceRepository;

    @Spy
    private ModelMapper modelMapper;

    private final String authorization = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJEb2FQZXQgQXBwbGljYXRpb24iLCJzdWIiOiIxIiwiaWF0IjoxNjgxNjkyOTg2LCJleHAiOjE2ODE2OTY1ODYsImNsYXNzVHlwZSI6IkRPTk9SIn0.xkg_0ZycUof3n6Gbd2zbvM0S4SYToUlA5pmFg1gqyRM";


    @Test
    void getAll() {
        when(tokenService.getUserIdFromToken(anyString())).thenReturn(1L);
        when(assistanceRepository.findAllByOngId(any(Pageable.class), anyLong())).thenReturn(new PageImpl<>(getAssistanceArray()));

        var actualAssistanceResponse = assistanceService.getAll(PageRequest.of(0, 10), authorization);

        assertNotNull(actualAssistanceResponse.getContent());
        assertEquals(2, actualAssistanceResponse.getContent().size());
        assertEquals(getAssistanceArray().get(0).getName(), actualAssistanceResponse.getContent().get(0).getName());
    }

    @Test
    void getById(){
        when(tokenService.getUserIdFromToken(anyString())).thenReturn(1L);
        when(assistanceRepository.findById(anyLong())).thenReturn(Optional.of(getAssistance()));

        var actualAssistanceResponse = assistanceService.getById(1L, authorization);

        assertNotNull(actualAssistanceResponse);
        assertTrue(actualAssistanceResponse.getStatus());
        assertEquals(getAssistanceResponse().getId(), actualAssistanceResponse.getId());
        assertEquals(getAssistanceResponse().getName(), actualAssistanceResponse.getName());
        assertEquals(getAssistanceResponse().getAssistanceCategory(), actualAssistanceResponse.getAssistanceCategory());
    }

    @Test
    void getAssistanceCategories(){
        var response = assistanceService.getAssistanceCategories();

        assertNotNull(response);
        assertEquals(AssistanceCategory.class, response.get(0).getClass());
    }

    @Test
    void create(){
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        when(tokenService.getUserIdFromToken(anyString())).thenReturn(1L);
        when(ongRepository.findById(anyLong())).thenReturn(Optional.of(ONGFactory.getONG()));
        when(assistanceRepository.save(any())).thenReturn(getAssistance());

        var actualAssistanceResponse = assistanceService.create(getAssistanceRequest(), authorization);

        assertNotNull(actualAssistanceResponse);
        verify(assistanceRepository, times(1)).save(any());
    }

    @Test
    void updateById() {
        when(tokenService.getUserIdFromToken(anyString())).thenReturn(1L);
        when(assistanceRepository.findById(anyLong())).thenReturn(Optional.of(getAssistance()));
        when(assistanceRepository.save(any())).thenReturn(getAssistance());

        var actualAssistanceResponse = assistanceService.updateById(1L, getAssistanceRequest(), authorization);

        assertNotNull(actualAssistanceResponse);
        verify(assistanceRepository, times(1)).save(any());
    }

    @Test
    void updateStatus_WhenSendAssistancetId_ExpectedAssistanceResponse() {
        when(tokenService.getUserIdFromToken(anyString())).thenReturn(1L);
        when(assistanceRepository.findById(anyLong())).thenReturn(Optional.of(getAssistance()));
        when(assistanceRepository.save(any())).thenReturn(getAssistance());

        var response = assistanceService.updateStatus(1L, authorization);

        assertNotNull(response);
        assertEquals(AssistanceResponse.class, response.getClass());
        assertEquals(getAssistance().getName(), response.getName());
        assertEquals(Boolean.TRUE, response.getStatus());
    }

    @Test
    void findAssistanceById_WhenSendAssistanceId_ExpectedAssistance() {
        when(assistanceRepository.findById(anyLong())).thenReturn(Optional.of(getAssistance()));

        var response = assistanceService.findAssistanceById(1L);

        assertNotNull(response);
        assertEquals(Assistance.class, response.getClass());
        assertEquals(getAssistance().getName(), response.getName());
        assertEquals(Boolean.TRUE, response.getStatus());
    }

}