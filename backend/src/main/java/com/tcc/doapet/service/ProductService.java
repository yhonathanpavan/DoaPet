package com.tcc.doapet.service;

import com.tcc.doapet.model.dto.request.ProductRequest;
import com.tcc.doapet.model.dto.response.ProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.net.URI;

public interface ProductService {

    URI save(ProductRequest productRequest);

    Page<ProductResponse> findAll(Pageable pageable);

    ProductResponse findOne(Long id);

    ProductResponse update(Long id, ProductRequest productRequest);

    ProductResponse updateStatus(Long id);
}
