package com.tcc.doapet.controller;

import com.tcc.doapet.model.dto.request.DonorRequest;
import com.tcc.doapet.model.dto.response.DonorResponse;
import com.tcc.doapet.service.DonorService;
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
@RequestMapping("/donors")
@RequiredArgsConstructor
public class DonorController {

    private final DonorService donorService;

    @GetMapping
    public ResponseEntity<Page<DonorResponse>> getAll(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.ok(donorService.getAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DonorResponse> getById(@PathVariable Long id){
        return ResponseEntity.ok(donorService.getById(id));
    }

    @Transactional
    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody DonorRequest donorRequest){
        return ResponseEntity.created(donorService.create(donorRequest)).build();
    }

    @Transactional
    @PatchMapping("/{id}")
    public ResponseEntity<DonorResponse> updateById(@PathVariable Long id,
                                                         @RequestBody DonorRequest donorRequest){
        return ResponseEntity.ok(donorService.updateById(id, donorRequest));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<?> updateStatus(@PathVariable Long id){
        return ResponseEntity.ok(donorService.updateStatus(id));
    }

}
