package com.tcc.doapet.controller;

import com.tcc.doapet.config.annotations.Donors.*;
import com.tcc.doapet.helper.TokenValidation;
import com.tcc.doapet.model.dto.request.DonorRequest;
import com.tcc.doapet.model.dto.response.DonorResponse;
import com.tcc.doapet.service.DonorService;
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

@RestController
@RequestMapping("/donors")
@RequiredArgsConstructor
public class DonorController {

    private final DonorService donorService;

    @GetAllDonors
    @GetMapping
    public ResponseEntity<Page<DonorResponse>> getAll(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.ok(donorService.getAll(pageable));
    }

    @GetDonorById
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')" +
            "|| hasRole('ROLE_DONOR')")
    public ResponseEntity<DonorResponse> getById(@Parameter(description = "ID do doador requerido para requisição")
                                                 @PathVariable Long id,
                                                 @Parameter(hidden = true)
                                                 @RequestHeader("Authorization") String authorization){

        TokenValidation.validateToken(id, authorization);
        return ResponseEntity.ok(donorService.getById(id));
    }

    @PostDonor
    @Transactional
    @PostMapping
    public ResponseEntity<Void> create(@io.swagger.v3.oas.annotations.parameters.RequestBody(
                                        description = "Requerido para a cadastro de um novo doador")
                                       @Valid @RequestBody DonorRequest donorRequest){

        return ResponseEntity.created(donorService.create(donorRequest)).build();
    }

    @PatchDonor
    @Transactional
    @PatchMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')" +
            "|| hasRole('ROLE_DONOR')")
    public ResponseEntity<DonorResponse> updateById(@Parameter(description = "ID do doador requerido para atualização")
                                                    @PathVariable Long id,
                                                    @io.swagger.v3.oas.annotations.parameters.RequestBody(
                                                    description = "Requerido para a atualização de um doador")
                                                    @RequestBody DonorRequest donorRequest,
                                                    @Parameter(hidden = true)
                                                    @RequestHeader("Authorization") String authorization){

        TokenValidation.validateToken(id, authorization);
        return ResponseEntity.ok(donorService.updateById(id, donorRequest));
    }

    @PatchDonorStatus
    @PatchMapping("/{id}/status")
    @PreAuthorize("hasRole('ROLE_ADMIN')" +
            "|| hasRole('ROLE_DONOR')")
    public ResponseEntity<?> updateStatus(@PathVariable Long id,
                                          @Parameter(hidden = true)
                                          @RequestHeader("Authorization") String authorization){

        TokenValidation.validateToken(id, authorization);
        return ResponseEntity.ok(donorService.updateStatus(id));
    }

}
