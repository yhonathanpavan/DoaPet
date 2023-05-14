package com.tcc.doapet.controller;

import com.tcc.doapet.config.annotations.Assistances.*;
import com.tcc.doapet.model.dto.request.AssistanceRequest;
import com.tcc.doapet.model.dto.response.AssistanceResponse;
import com.tcc.doapet.model.enums.AssistanceCategory;
import com.tcc.doapet.service.AssistanceService;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/assistances")
@RequiredArgsConstructor
public class AssistanceController {

    private final AssistanceService assistanceService;

    @GetAllAssistances
    @GetMapping
    public ResponseEntity<Page<AssistanceResponse>> getAll(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.ok(assistanceService.getAll(pageable));
    }

    @GetAssistanceById
    @GetMapping("/{id}")
    public ResponseEntity<AssistanceResponse> getById(@Parameter(description = "ID do serviço requerido para requisição")
                                                      @PathVariable Long id){

        return ResponseEntity.ok(assistanceService.getById(id));
    }

    @GetAssistanceCategories
    @GetMapping("/categories")
    public ResponseEntity<List<AssistanceCategory>> getAssistanceCategories(){

        return ResponseEntity.ok(assistanceService.getAssistanceCategories());
    }

    @PostAssistance
    @Transactional
    @PostMapping
    public ResponseEntity<Void> create(@io.swagger.v3.oas.annotations.parameters.RequestBody(
                                       description = "Requerido para a criação de um novo serviço")
                                       @Valid @RequestBody AssistanceRequest assistanceRequest){

        return ResponseEntity.created(assistanceService.create(assistanceRequest)).build();
    }

    @PatchAssistance
    @Transactional
    @PatchMapping("/{id}")
    public ResponseEntity<AssistanceResponse> updateById(@Parameter(description = "ID requerido para atualização")
                                                         @PathVariable Long id,
                                                         @io.swagger.v3.oas.annotations.parameters.RequestBody(
                                                         description = "Requerido para a atualização de um novo serviço")
                                                         @RequestBody AssistanceRequest assistanceRequest){

        return ResponseEntity.ok(assistanceService.updateById(id, assistanceRequest));
    }

    @PatchAssistanceStatus
    @PatchMapping("/{id}/status")
    public ResponseEntity<?> updateStatus(@Parameter(description = "ID requerido para alteração de status")
                                          @PathVariable Long id){

        return ResponseEntity.ok(assistanceService.updateStatus(id));
    }

}
