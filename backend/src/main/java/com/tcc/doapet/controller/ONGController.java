package com.tcc.doapet.controller;

import com.tcc.doapet.model.dto.request.ONGRequest;
import com.tcc.doapet.model.dto.request.OrderRequest;
import com.tcc.doapet.model.dto.response.ONGResponse;
import com.tcc.doapet.model.dto.response.OrderResponse;
import com.tcc.doapet.service.ONGService;
import com.tcc.doapet.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Path;

@RestController
@RequestMapping("/ongs")
@RequiredArgsConstructor
public class ONGController {

    private final ONGService ongService;

    private final OrderService orderService;

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

    @PostMapping("/{ongId}/orders")
    public ResponseEntity<OrderResponse> saveOrder(@PathVariable Long ongId,
                                                   @RequestBody OrderRequest orderRequest){
        return ResponseEntity.created(orderService.save(ongId, orderRequest)).build();
    }

    @GetMapping("/{ongId}/orders")
    public ResponseEntity<Page<OrderResponse>> findAllOrders(@PathVariable Long ongId,
            @PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.ok(orderService.findAll(ongId, pageable));
    }

    @GetMapping("/{ongId}/orders/{orderId}")
    public ResponseEntity<OrderResponse> findOrderById(@PathVariable Long ongId,
                                                       @PathVariable Long orderId){
        return ResponseEntity.ok(orderService.findOne(ongId, orderId));
    }

    @PatchMapping("/{ongId}/orders/{orderId}")
    public ResponseEntity<OrderResponse> updateOrderById(@PathVariable Long ongId,
                                                         @PathVariable Long orderId,
                                                         @RequestBody OrderRequest orderRequest){
        return ResponseEntity.ok(orderService.update(ongId, orderId, orderRequest));
    }



}
