package com.tcc.doapet.controller;

import com.tcc.doapet.config.annotations.Products.*;
import com.tcc.doapet.model.dto.request.ProductRequest;
import com.tcc.doapet.model.dto.response.ProductResponse;
import com.tcc.doapet.model.enums.Measures;
import com.tcc.doapet.model.enums.ProductCategory;
import com.tcc.doapet.service.ProductService;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST})
    @PostMapping
    @PostProduct
    public ResponseEntity<ProductResponse> save(@io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Requerido para a criação de um novo produto")
                                                    @Valid @RequestBody ProductRequest productRequest){
        return ResponseEntity.created(productService.save(productRequest)).build();
    }

    @GetMapping
    @GetAllProducts
    public ResponseEntity<Page<ProductResponse>> findAll(@PageableDefault(sort = "id", direction = Sort.Direction.ASC)
                                                         Pageable pageable){
        return ResponseEntity.ok(productService.findAll(pageable));
    }

    @GetMapping("/{id}")
    @GetProductById
    public ResponseEntity<ProductResponse> findOne(@Parameter(description = "ID do produto requerido para requisição")
                                                       @PathVariable Long id){
        return ResponseEntity.ok(productService.findOne(id));
    }

    @CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST})
    @GetMapping("/categories")
    @GetProductCategories
    public ResponseEntity<List<ProductCategory>> getProductCategories(){
        return ResponseEntity.ok(productService.getProductCategories());
    }

    @CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST})
    @GetMapping("/measures")
    @GetProductMeasures
    public ResponseEntity<List<Measures>> getProductMeasures(){
        return ResponseEntity.ok(productService.getProductMeasures());
    }

    @PatchMapping("/{id}")
    @PatchProduct
    public ResponseEntity<ProductResponse> update(@Parameter(description = "ID requerido para atualização")
                                                      @PathVariable Long id,
                                                  @io.swagger.v3.oas.annotations.parameters.RequestBody(
                                                          description = "Requerido para a atualização de um novo produto")@RequestBody ProductRequest productRequest){
        return ResponseEntity.ok(productService.update(id, productRequest));
    }

    @PatchMapping("/{id}/status")
    @PatchProductStatus
    public ResponseEntity<?> updateStatus(@Parameter(description = "ID requerido para alteração de status")
                                              @PathVariable Long id){
        return ResponseEntity.ok(productService.updateStatus(id));
    }
}
