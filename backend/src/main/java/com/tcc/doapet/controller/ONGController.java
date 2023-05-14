package com.tcc.doapet.controller;

import com.tcc.doapet.helper.TokenValidation;
import com.tcc.doapet.config.annotations.ONG.*;
import com.tcc.doapet.config.annotations.ONG.PatchONG;
import com.tcc.doapet.config.annotations.Orders.*;
import com.tcc.doapet.model.dto.request.ONGRequest;
import com.tcc.doapet.model.dto.request.OrderRequest;
import com.tcc.doapet.model.dto.request.OrderRequestUpdate;
import com.tcc.doapet.model.dto.response.ONGResponse;
import com.tcc.doapet.model.dto.response.OrderResponse;
import com.tcc.doapet.model.enums.PriorityLevelStatus;
import com.tcc.doapet.service.ONGService;
import com.tcc.doapet.service.OrderService;
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
@RequestMapping("/ongs")
@RequiredArgsConstructor
public class ONGController {

    private final ONGService ongService;

    private final OrderService orderService;

    @GetAllONGs
    @GetMapping
    public ResponseEntity<Page<ONGResponse>> getAll(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable){

        return ResponseEntity.ok(ongService.getAll(pageable));
    }

    @GetONGById
    @GetMapping("/{id}")
    public ResponseEntity<ONGResponse> getById(@Parameter(description = "ID da ONG requerida para requisição")
                                               @PathVariable Long id){

        return ResponseEntity.ok(ongService.getById(id));
    }

    @PostONG
    @Transactional
    @PostMapping
    public ResponseEntity<Void> create(@io.swagger.v3.oas.annotations.parameters.RequestBody(
                                        description = "Requerido para a criação de uma nova ONG")
                                       @Valid @RequestBody ONGRequest ongRequest){

        return ResponseEntity.created(ongService.create(ongRequest)).build();
    }

    @PatchONG
    @Transactional
    @PatchMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')" +
            "|| hasRole('ROLE_ONG')")
    public ResponseEntity<ONGResponse> updateById(@Parameter(description = "ID da ONG requerida para atualização")
                                                  @PathVariable Long id,
                                                  @io.swagger.v3.oas.annotations.parameters.RequestBody(
                                                  description = "Requerido para a atualiação de uma ONG")
                                                  @RequestBody ONGRequest ongRequest,
                                                  @RequestHeader("Authorization") String authorization){

        TokenValidation.validateToken(id, authorization);
        return ResponseEntity.ok(ongService.updateById(id, ongRequest));
    }

    @PostOrder
    @PostMapping("/{ongId}/orders")
    @PreAuthorize("hasRole('ROLE_ADMIN')" +
            "|| hasRole('ROLE_ONG')")
    public ResponseEntity<OrderResponse> saveOrder(@Parameter(description = "ID do pedido requerida para criação")
                                                   @PathVariable Long ongId,
                                                   @io.swagger.v3.oas.annotations.parameters.RequestBody(
                                                   description = "Requerido para a criação de um pedido")
                                                   @Valid @RequestBody OrderRequest orderRequest){

        return ResponseEntity.created(orderService.save(ongId, orderRequest)).build();
    }

    @GetAllOrders
    @GetMapping("/{ongId}/orders")
    public ResponseEntity<Page<OrderResponse>> findAllOrders(@Parameter(description = "ID da ONG requerida para requisição")
                                                             @PathVariable Long ongId,
                                                             @PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable){

        return ResponseEntity.ok(orderService.findAll(ongId, pageable));
    }

    @GetOrderById
    @GetMapping("/{ongId}/orders/{orderId}")
    public ResponseEntity<OrderResponse> findOrderById(@Parameter(description = "ID da ONG requerida para requisição")
                                                       @PathVariable Long ongId,
                                                       @Parameter(description = "ID do pedido requerido para requisição")
                                                       @PathVariable Long orderId){

        return ResponseEntity.ok(orderService.findOne(ongId, orderId));
    }

    @GetOrderPrioritiesLevelStatus
    @GetMapping("/priorities_level_status")
    public ResponseEntity<List<PriorityLevelStatus>> getPrioritiesLevelStatus(){

        return ResponseEntity.ok(orderService.getPrioritiesLevelStatus());
    }


    @PatchOrder
    @PatchMapping("/{ongId}/orders/{orderId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')" +
            "|| hasRole('ROLE_ONG')")
    public ResponseEntity<OrderResponse> updateOrderById(@Parameter(description = "ID da ONG requerida para atualização")
                                                         @PathVariable Long ongId,
                                                         @Parameter(description = "ID do pedido requerido para requisição")
                                                         @PathVariable Long orderId,
                                                         @io.swagger.v3.oas.annotations.parameters.RequestBody(
                                                         description = "Requerido para a atualização de um pedido")
                                                         @RequestBody OrderRequestUpdate orderRequest,
                                                         @RequestHeader("Authorization") String authorization){

        TokenValidation.validateToken(ongId, authorization);
        return ResponseEntity.ok(orderService.update(ongId, orderId, orderRequest));
    }

    @PatchONGStatus
    @PatchMapping("/{id}/status")
    @PreAuthorize("hasRole('ROLE_ADMIN')" +
            "|| hasRole('ROLE_ONG')")
    public ResponseEntity<?> updateStatus(@PathVariable Long id,
                                          @RequestHeader("Authorization") String authorization){

        TokenValidation.validateToken(id, authorization);
        return ResponseEntity.ok(ongService.updateStatus(id));
    }

    @PatchCancelOrder
    @PatchMapping("{ongId}/orders/{orderId}/cancel")
    @PreAuthorize("hasRole('ROLE_ADMIN')" +
            "|| hasRole('ROLE_ONG')")
    public ResponseEntity<?> cancelOrder(@Parameter(description = "ID da ONG requerida para atualização")
                                         @PathVariable Long ongId,
                                         @Parameter(description = "ID do pedido requerido para requisição")
                                         @PathVariable Long orderId,
                                         @RequestHeader("Authorization") String authorization){

        TokenValidation.validateToken(ongId, authorization);
        return ResponseEntity.ok(orderService.cancelOrder(ongId, orderId));
    }

}
