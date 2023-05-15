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

    @CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST})
    @GetMapping
    @GetAllAssistances
    public ResponseEntity<Page<AssistanceResponse>> getAll(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.ok(assistanceService.getAll(pageable));
    }

    @CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST})
    @GetMapping("/{id}")
    @GetAssistanceById
    public ResponseEntity<AssistanceResponse> getById(@Parameter(description = "ID do serviço requerido para requisição")
                                                          @PathVariable Long id){
        return ResponseEntity.ok(assistanceService.getById(id));
    }

    @CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST})
    @GetMapping("/categories")
    @GetAssistanceCategories
    public ResponseEntity<List<AssistanceCategory>> getAssistanceCategories(){
        return ResponseEntity.ok(assistanceService.getAssistanceCategories());
    }

    @CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST})
    @Transactional
    @PostMapping
    @PostAssistance
    public ResponseEntity<Void> create(@io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Requerido para a criação de um novo serviço")
                                           @Valid @RequestBody AssistanceRequest assistanceRequest){
        return ResponseEntity.created(assistanceService.create(assistanceRequest)).build();
    }

    @CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST})
    @Transactional
    @PatchMapping("/{id}")
    @PatchAssistance
    public ResponseEntity<AssistanceResponse> updateById(@Parameter(description = "ID requerido para atualização")
                                                             @PathVariable Long id,
                                                         @io.swagger.v3.oas.annotations.parameters.RequestBody(
                                                                 description = "Requerido para a atualização de um novo serviço")
                                                         @RequestBody AssistanceRequest assistanceRequest){
        return ResponseEntity.ok(assistanceService.updateById(id, assistanceRequest));
    }

    @CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST})
    @PatchMapping("/{id}/status")
    @PatchAssistanceStatus
    public ResponseEntity<?> updateStatus(@Parameter(description = "ID requerido para alteração de status")
                                              @PathVariable Long id){
        return ResponseEntity.ok(assistanceService.updateStatus(id));
    }

}
