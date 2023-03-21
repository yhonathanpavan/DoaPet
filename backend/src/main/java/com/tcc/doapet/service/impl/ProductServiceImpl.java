package com.tcc.doapet.service.impl;

import com.tcc.doapet.model.dto.request.ProductRequest;
import com.tcc.doapet.model.dto.response.ProductResponse;
import com.tcc.doapet.model.entity.Product;
import com.tcc.doapet.repository.ProductRepository;
import com.tcc.doapet.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ModelMapper mapper;

    private final ProductRepository productRepository;

    @Override
    public URI save(ProductRequest productRequest) {
        Product product = mapper.map(productRequest, Product.class);
        product.setStatus(Boolean.TRUE);
        productRepository.save(product);
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").build(product.getId());
    }

    @Override
    public Page<ProductResponse> findAll(Pageable pageable) {
        Page<Product> products = productRepository.findAll(pageable);
        return products.map(e -> mapper.map(e, ProductResponse.class));
    }

    @Override
    public ProductResponse findOne(Long id) {
        return mapper.map(findProductById(id), ProductResponse.class);
    }

    @Override
    public ProductResponse update(Long id, ProductRequest productRequest) {
        Product productEntity = findProductById(id);
        mapper.map(productRequest, productEntity);
        return mapper.map(productRepository.save(productEntity), ProductResponse.class);
    }

    @Override
    public ProductResponse updateStatus(Long id) {
        Product product = findProductById(id);
        product.setStatus(!product.getStatus());
        return mapper.map(productRepository.save(product), ProductResponse.class);
    }

    protected Product findProductById(Long id){
        return productRepository.findById(id).orElseThrow();
    }

}
