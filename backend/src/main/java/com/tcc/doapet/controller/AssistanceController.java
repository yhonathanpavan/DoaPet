package com.tcc.doapet.controller;

import com.tcc.doapet.model.dto.request.AssistanceRequest;
import com.tcc.doapet.model.dto.response.AssistanceResponse;
import com.tcc.doapet.service.AssistanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/assistances")
@RequiredArgsConstructor
public class AssistanceController {

    private final AssistanceService assistanceService;

    @GetMapping
    public ResponseEntity<Page<AssistanceResponse>> getAll(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.ok(assistanceService.getAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssistanceResponse> create(@PathVariable Long id){
        return ResponseEntity.ok(assistanceService.getById(id));
    }

    @Transactional
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody AssistanceRequest assistanceRequest){
        return ResponseEntity.created(assistanceService.create(assistanceRequest)).build();
    }

    @Transactional
    @PatchMapping("/{id}")
    public ResponseEntity<AssistanceResponse> updateById(@PathVariable Long id,
                                                         @RequestBody AssistanceRequest assistanceRequest){
        return ResponseEntity.ok(assistanceService.updateById(id, assistanceRequest));
    }

}
