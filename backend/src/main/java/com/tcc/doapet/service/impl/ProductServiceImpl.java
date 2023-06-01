package com.tcc.doapet.service.impl;

import com.tcc.doapet.model.dto.request.ProductRequest;
import com.tcc.doapet.model.dto.response.ProductResponse;
import com.tcc.doapet.model.entity.ONG;
import com.tcc.doapet.model.entity.Product;
import com.tcc.doapet.model.enums.Measures;
import com.tcc.doapet.model.enums.ProductCategory;
import com.tcc.doapet.repository.ONGRepository;
import com.tcc.doapet.repository.ProductRepository;
import com.tcc.doapet.service.ProductService;
import com.tcc.doapet.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.ws.rs.ForbiddenException;
import javax.ws.rs.NotFoundException;
import java.net.URI;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final TokenService tokenService;
    private final ONGRepository ongRepository;
    private final ModelMapper mapper;
    private final ProductRepository productRepository;

    @Override
    public URI save(ProductRequest productRequest, String authorization) {
        var ong = getOngByToken(authorization);
        Product product = mapper.map(productRequest, Product.class);
        product.setStatus(Boolean.TRUE);
        product.setOng(ong);
        productRepository.save(product);
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").build(product.getId());
    }

    @Override
    public Page<ProductResponse> findAll(Pageable pageable, String authorization) {
        var ongId = getOngIdByToken(authorization);
        Page<Product> products = productRepository.findAllByOngId(pageable, ongId);
        return products.map(e -> mapper.map(e, ProductResponse.class));
    }

    @Override
    public ProductResponse findOne(Long id, String authorization) {
        var product = findProductById(id);
        validateIfTheAuthenticatedONGBelongsToProduct(product, authorization);
        return mapper.map(product, ProductResponse.class);
    }

    @Override
    public List<ProductCategory> getProductCategories() {
        return List.of(ProductCategory.values());
    }

    @Override
    public List<Measures> getProductMeasures() {
        return List.of(Measures.values());
    }

    @Override
    public ProductResponse update(Long id, ProductRequest productRequest, String authorization) {
        Product productEntity = findProductById(id);
        validateIfTheAuthenticatedONGBelongsToProduct(productEntity, authorization);
        mapper.map(productRequest, productEntity);
        return mapper.map(productRepository.save(productEntity), ProductResponse.class);
    }

    @Override
    public ProductResponse updateStatus(Long id, String authorization) {
        Product product = findProductById(id);
        validateIfTheAuthenticatedONGBelongsToProduct(product, authorization);
        product.setStatus(!product.getStatus());
        return mapper.map(productRepository.save(product), ProductResponse.class);
    }

    protected Product findProductById(Long id){
        return productRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    private ONG getOngByToken(String authorization){
        var token = authorization.substring(7);
        var ongId = tokenService.getUserIdFromToken(token);
        return ongRepository.findById(ongId).orElseThrow(NotFoundException::new);
    }

    private Long getOngIdByToken(String authorization){
        var token = authorization.substring(7);
        return tokenService.getUserIdFromToken(token);
    }

    private void validateIfTheAuthenticatedONGBelongsToProduct(Product assistance, String authorization){
        var ongId = getOngIdByToken(authorization);
        if(!assistance.getOng().getId().equals(ongId)){
            throw new ForbiddenException();
        }
    }

}
