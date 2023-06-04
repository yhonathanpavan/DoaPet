package com.tcc.doapet.controller;

import com.tcc.doapet.config.annotations.Donors.*;
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
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/donors")
@RequiredArgsConstructor
public class DonorController {

    private final DonorService donorService;

    @CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST})
    @GetMapping
    @GetAllDonors
    public ResponseEntity<Page<DonorResponse>> getAll(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.ok(donorService.getAll(pageable));
    }

    @CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST})
    @GetMapping("/{id}")
    @GetDonorById
    public ResponseEntity<DonorResponse> getById(@Parameter(description = "ID do doador requerido para requisição")
                                                     @PathVariable Long id){
        return ResponseEntity.ok(donorService.getById(id));
    }

    @CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST})
    @Transactional
    @PostMapping
    @PostDonor
    public ResponseEntity<Void> create(@io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Requerido para a cadastro de um novo doador")
                                           @Valid @RequestBody DonorRequest donorRequest){
        return ResponseEntity.created(donorService.create(donorRequest)).build();
    }

    @Transactional
    @PatchMapping("/{id}")
    @PatchDonor
    public ResponseEntity<DonorResponse> updateById(@Parameter(description = "ID do doador requerido para atualização")
                                                        @PathVariable Long id,
                                                    @io.swagger.v3.oas.annotations.parameters.RequestBody(
                                                            description = "Requerido para a atualização de um doador")
                                                    @RequestBody DonorRequest donorRequest){
        return ResponseEntity.ok(donorService.updateById(id, donorRequest));
    }

    @PatchMapping("/{id}/status")
    @PatchDonorStatus
    public ResponseEntity<?> updateStatus(@PathVariable Long id){
        return ResponseEntity.ok(donorService.updateStatus(id));
    }

}
