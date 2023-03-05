package com.tcc.doapet.controller;

import com.tcc.doapet.model.dto.request.ONGRequest;
import com.tcc.doapet.model.dto.response.ONGResponse;
import com.tcc.doapet.service.ONGService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/ongs")
@RequiredArgsConstructor
public class ONGController {

    private final ONGService ongService;

    @GetMapping
    public ResponseEntity<Page<ONGResponse>> getAll(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.ok(ongService.getAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ONGResponse> create(@PathVariable Long id){
        return ResponseEntity.ok(ongService.getById(id));
    }

    @Transactional
    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody ONGRequest ongRequest){
        return ResponseEntity.created(ongService.create(ongRequest)).build();
    }

    @Transactional
    @PatchMapping("/{id}")
    public ResponseEntity<ONGResponse> updateById(@PathVariable Long id,
                                                         @RequestBody ONGRequest ongRequest){
        return ResponseEntity.ok(ongService.updateById(id, ongRequest));
    }

}
