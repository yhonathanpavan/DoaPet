package com.tcc.doapet.controller;

import com.tcc.doapet.model.dto.request.ProductRequest;
import com.tcc.doapet.model.dto.response.ProductResponse;
import com.tcc.doapet.model.enums.Measures;
import com.tcc.doapet.model.enums.ProductCategory;
import com.tcc.doapet.service.ProductService;
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

    @PostMapping
    public ResponseEntity<ProductResponse> save(@Valid @RequestBody ProductRequest productRequest){
        return ResponseEntity.created(productService.save(productRequest)).build();
    }

    @GetMapping
    public ResponseEntity<Page<ProductResponse>> findAll(@PageableDefault(sort = "id", direction = Sort.Direction.ASC)
                                                         Pageable pageable){
        return ResponseEntity.ok(productService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> findOne(@PathVariable Long id){
        return ResponseEntity.ok(productService.findOne(id));
    }

    @GetMapping("/categories")
    public ResponseEntity<List<ProductCategory>> getProductCategories(){
        return ResponseEntity.ok(productService.getProductCategories());
    }

    @GetMapping("/measures")
    public ResponseEntity<List<Measures>> getProductMeasures(){
        return ResponseEntity.ok(productService.getProductMeasures());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProductResponse> update(@PathVariable Long id, @RequestBody ProductRequest productRequest){
        return ResponseEntity.ok(productService.update(id, productRequest));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<?> updateStatus(@PathVariable Long id){
        return ResponseEntity.ok(productService.updateStatus(id));
    }
}
