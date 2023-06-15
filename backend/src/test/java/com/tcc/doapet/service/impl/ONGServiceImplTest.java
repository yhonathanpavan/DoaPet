package com.tcc.doapet.service.impl;

import com.tcc.doapet.factory.DonorFactory;
import com.tcc.doapet.factory.ONGFactory;
import com.tcc.doapet.factory.ProductFactory;
import com.tcc.doapet.model.dto.response.ONGResponse;
import com.tcc.doapet.model.dto.response.ProductResponse;
import com.tcc.doapet.model.entity.ONG;
import com.tcc.doapet.model.entity.Product;
import com.tcc.doapet.repository.DonorRepository;
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
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.ws.rs.WebApplicationException;
import java.util.Optional;

import static com.tcc.doapet.factory.DonorFactory.getDonorRequest;
import static com.tcc.doapet.factory.ONGFactory.*;
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

    @Mock(answer = Answers.RETURNS_SMART_NULLS)
    private DonorRepository donorRepository;

    @Spy
    private ModelMapper modelMapper;

    @Spy
    private PasswordEncoder passwordEncoder;

    @Test
    void getAll(){
        when(ongRepository.findAll(any(Pageable.class))).thenReturn(new PageImpl<>(getONGArray()));

        var actualONGResponse = ongService.getAll(PageRequest.of(0, 10));

        assertNotNull(actualONGResponse.getContent());
        assertEquals(2, actualONGResponse.getContent().size());
        assertEquals(getONGArray().get(0).getName(), actualONGResponse.getContent().get(0).getName());
    }

    @Test
    void getById(){
        when(ongRepository.findById(anyLong())).thenReturn(Optional.of(getONG()));

        var actualONGResponse = ongService.getById(1L);

        assertNotNull(actualONGResponse);
        assertTrue(actualONGResponse.getStatus());
        assertEquals(getONGResponse().getId(), actualONGResponse.getId());
        assertEquals(getONGResponse().getName(), actualONGResponse.getName());
        assertEquals(getONGResponse().getCnpj(), actualONGResponse.getCnpj());
        assertEquals(getONGResponse().getEmail(), actualONGResponse.getEmail());
    }

    @Test
    void create(){
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        when(ongRepository.save(any())).thenReturn(getONG());
        when(donorRepository.findByEmail(anyString())).thenReturn(Optional.empty());

        var actualONGResponse = ongService.create(getONGRequest());

        assertNotNull(actualONGResponse);
        verify(ongRepository, times(1)).save(any());
    }

    @Test
    void whenCreateAndEmailAlreadyRegisteredThrowAConflictException(){
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        var webApplicationException = new WebApplicationException();

        when(donorRepository.findByEmail(anyString())).thenReturn(Optional.of(DonorFactory.getDonor()));

        try {
            var actualDonorResponse = ongService.create(getONGRequest());
        }catch(WebApplicationException ex){
            webApplicationException = ex;
        }

        assertEquals(HttpStatus.CONFLICT.value(), webApplicationException.getResponse().getStatus());
    }

    @Test
    void updateById(){
        when(ongRepository.findById(anyLong())).thenReturn(Optional.of(getONG()));
        when(ongRepository.save(any())).thenReturn(getONG());
        when(donorRepository.findByEmail(anyString())).thenReturn(Optional.empty());

        var actualONGResponse = ongService.updateById(1L, getONGRequest());

        assertNotNull(actualONGResponse);
        verify(ongRepository, times(1)).save(any());
    }

    @Test
    void updateStatus_WhenSendONGId_ExpectedONGResponse() {
        when(ongRepository.findById(anyLong())).thenReturn(Optional.of(getONG()));
        when(ongRepository.save(any())).thenReturn(getONG());

        var response = ongService.updateStatus(1L);

        assertNotNull(response);
        assertEquals(ONGResponse.class, response.getClass());
        assertEquals(getONGResponse().getName(), response.getName());
        assertEquals(Boolean.TRUE, response.getStatus());
    }

    @Test
    void findONGById_WhenSendONGId_ExpectedONG() {
        when(ongRepository.findById(anyLong())).thenReturn(Optional.of(getONG()));

        var response = ongService.findOngById(1L);

        assertNotNull(response);
        assertEquals(ONG.class, response.getClass());
        assertEquals(getONGResponse().getName(), response.getName());
        assertEquals(Boolean.TRUE, response.getStatus());
    }

}