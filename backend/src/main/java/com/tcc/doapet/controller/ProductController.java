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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @PostProduct
    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')" +
            "|| hasRole('ROLE_ONG')")
    public ResponseEntity<ProductResponse> save(@io.swagger.v3.oas.annotations.parameters.RequestBody(
                                                description = "Requerido para a criação de um novo produto")
                                                @Valid @RequestBody ProductRequest productRequest,
                                                @Parameter(hidden = true)
                                                @RequestHeader("Authorization") String authorization){

        return ResponseEntity.created(productService.save(productRequest)).build();
    }

    @GetAllProducts
    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')" +
            "|| hasRole('ROLE_ONG')")
    public ResponseEntity<Page<ProductResponse>> findAll(@PageableDefault(sort = "id", direction = Sort.Direction.ASC)
                                                         Pageable pageable,
                                                         @Parameter(hidden = true)
                                                         @RequestHeader("Authorization") String authorization){

        return ResponseEntity.ok(productService.findAll(pageable));
    }

    @GetProductById
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')" +
            "|| hasRole('ROLE_ONG')")
    public ResponseEntity<ProductResponse> findOne(@Parameter(description = "ID do produto requerido para requisição")
                                                   @PathVariable Long id,
                                                   @Parameter(hidden = true)
                                                   @RequestHeader("Authorization") String authorization){

        return ResponseEntity.ok(productService.findOne(id));
    }

    @GetProductCategories
    @GetMapping("/categories")
    @PreAuthorize("hasRole('ROLE_ADMIN')" +
            "|| hasRole('ROLE_ONG')")
    public ResponseEntity<List<ProductCategory>> getProductCategories(@Parameter(hidden = true)
                                                                      @RequestHeader("Authorization") String authorization){

        return ResponseEntity.ok(productService.getProductCategories());
    }

    @GetProductMeasures
    @GetMapping("/measures")
    @PreAuthorize("hasRole('ROLE_ADMIN')" +
            "|| hasRole('ROLE_ONG')")
    public ResponseEntity<List<Measures>> getProductMeasures(){

        return ResponseEntity.ok(productService.getProductMeasures());
    }

    @PatchProduct
    @PatchMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')" +
            "|| hasRole('ROLE_ONG')")
    public ResponseEntity<ProductResponse> update(@Parameter(description = "ID requerido para atualização")
                                                  @PathVariable Long id,
                                                  @io.swagger.v3.oas.annotations.parameters.RequestBody(
                                                  description = "Requerido para a atualização de um novo produto")@RequestBody ProductRequest productRequest,
                                                  @Parameter(hidden = true)
                                                  @RequestHeader("Authorization") String authorization){

        return ResponseEntity.ok(productService.update(id, productRequest));
    }

    @PatchProductStatus
    @PatchMapping("/{id}/status")
    @PreAuthorize("hasRole('ROLE_ADMIN')" +
            "|| hasRole('ROLE_ONG')")
    public ResponseEntity<?> updateStatus(@Parameter(description = "ID requerido para alteração de status")
                                          @PathVariable Long id,
                                          @Parameter(hidden = true)
                                          @RequestHeader("Authorization") String authorization){

        return ResponseEntity.ok(productService.updateStatus(id));
    }
}
