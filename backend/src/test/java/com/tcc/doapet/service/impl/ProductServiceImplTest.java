package com.tcc.doapet.service.impl;

import com.tcc.doapet.factory.ProductFactory;
import com.tcc.doapet.model.dto.response.ProductResponse;
import com.tcc.doapet.model.entity.Product;
import com.tcc.doapet.repository.ProductRepository;
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

import java.net.URI;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @InjectMocks
    ProductServiceImpl productService;

    @Mock(answer = Answers.RETURNS_SMART_NULLS)
    ProductRepository productRepository;

    @Spy
    ModelMapper mapper;

    private static final Long ID = 1L;

    @Test
    void save_WhenSendProductRequest_ExpectedURI() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        when(productRepository.save(any())).thenReturn(ProductFactory.getProduct());

        var response = productService.save(ProductFactory.getProductRequest());

        assertNotNull(response);
        assertEquals(URI.class, response.getClass());
        verify(productRepository, times(1)).save(any());
    }

    @Test
    void findAll_WhenSendPageable_ExpectedPageProductResponse() {
        when(productRepository.findAll((Pageable) any())).thenReturn(ProductFactory.getProductPageable());

        Pageable page = PageRequest.of(0,10);
        var response = productService.findAll(page);

        assertNotNull(response.getContent());
        assertEquals(PageImpl.class, response.getClass());
        assertEquals(1, response.getContent().size());
        assertEquals(ProductFactory.getProduct().getName(), response.getContent().get(0).getName());
    }

    @Test
    void findOne_WhenSendProductId_ExpectedProductResponse() {
        when(productRepository.findById(anyLong())).thenReturn(Optional.ofNullable(ProductFactory.getProduct()));

        var response = productService.findOne(ID);

        assertNotNull(response);
        assertEquals(ProductResponse.class, response.getClass());
        assertEquals(ProductFactory.getProduct().getName(), response.getName());
        assertEquals(Boolean.TRUE, response.getStatus());
    }

    @Test
    void update_WhenSendProductRequestAndProductId_ExpectedProductResponse() {
        when(productRepository.findById(anyLong())).thenReturn(Optional.ofNullable(ProductFactory.getProduct()));
        when(productRepository.save(any())).thenReturn(ProductFactory.getProduct());

        var response = productService.update(ID, ProductFactory.getProductRequest());

        assertNotNull(response);
        assertEquals(ProductResponse.class, response.getClass());
        assertEquals(ProductFactory.getProduct().getName(), response.getName());
        assertEquals(Boolean.TRUE, response.getStatus());
    }

    @Test
    void findProductById_WhenSendProductId_ExpectedProduct() {
        when(productRepository.findById(anyLong())).thenReturn(Optional.ofNullable(ProductFactory.getProduct()));

        var response = productService.findProductById(ID);

        assertNotNull(response);
        assertEquals(Product.class, response.getClass());
        assertEquals(ProductFactory.getProduct().getName(), response.getName());
        assertEquals(Boolean.TRUE, response.getStatus());
    }
}