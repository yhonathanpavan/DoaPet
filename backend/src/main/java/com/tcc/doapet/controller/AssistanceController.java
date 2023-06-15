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
import org.springframework.security.access.prepost.PreAuthorize;
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
    @GetAllAssistances
    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')" +
            "|| hasRole('ROLE_ONG')")
    public ResponseEntity<Page<AssistanceResponse>> getAll(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable,
                                                           @Parameter(hidden = true)
                                                           @RequestHeader("Authorization") String authorization){

        return ResponseEntity.ok(assistanceService.getAll(pageable, authorization));
    }

    @CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST})
    @GetAssistanceById
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')" +
            "|| hasRole('ROLE_ONG')")
    public ResponseEntity<AssistanceResponse> getById(@Parameter(description = "ID do serviço requerido para requisição")
                                                      @PathVariable Long id,
                                                      @Parameter(hidden = true)
                                                      @RequestHeader("Authorization") String authorization){

        return ResponseEntity.ok(assistanceService.getById(id, authorization));
    }

    @CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST})
    @GetAssistanceCategories
    @GetMapping("/categories")
    @PreAuthorize("hasRole('ROLE_ADMIN')" +
            "|| hasRole('ROLE_ONG')")
    public ResponseEntity<List<AssistanceCategory>> getAssistanceCategories(){

        return ResponseEntity.ok(assistanceService.getAssistanceCategories());
    }

    @CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST})
    @PostAssistance
    @Transactional
    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')" +
            "|| hasRole('ROLE_ONG')")
    public ResponseEntity<Void> create(@io.swagger.v3.oas.annotations.parameters.RequestBody(
                                       description = "Requerido para a criação de um novo serviço")
                                       @Valid @RequestBody AssistanceRequest assistanceRequest,
                                       @Parameter(hidden = true)
                                       @RequestHeader("Authorization") String authorization){

        return ResponseEntity.created(assistanceService.create(assistanceRequest, authorization)).build();
    }

    @CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST})
    @PatchAssistance
    @Transactional
    @PatchMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')" +
            "|| hasRole('ROLE_ONG')")
    public ResponseEntity<AssistanceResponse> updateById(@Parameter(description = "ID requerido para atualização")
                                                         @PathVariable Long id,
                                                         @io.swagger.v3.oas.annotations.parameters.RequestBody(
                                                         description = "Requerido para a atualização de um novo serviço")
                                                         @RequestBody AssistanceRequest assistanceRequest,
                                                         @Parameter(hidden = true)
                                                         @RequestHeader("Authorization") String authorization){

        return ResponseEntity.ok(assistanceService.updateById(id, assistanceRequest, authorization));
    }

    @CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST})
    @PatchAssistanceStatus
    @PatchMapping("/{id}/status")
    @PreAuthorize("hasRole('ROLE_ADMIN')" +
            "|| hasRole('ROLE_ONG')")
    public ResponseEntity<?> updateStatus(@Parameter(description = "ID requerido para alteração de status")
                                          @PathVariable Long id,
                                          @Parameter(hidden = true)
                                          @RequestHeader("Authorization") String authorization){

        return ResponseEntity.ok(assistanceService.updateStatus(id, authorization));
    }

}
