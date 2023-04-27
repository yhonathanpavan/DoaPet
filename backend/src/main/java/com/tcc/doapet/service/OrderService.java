package com.tcc.doapet.service;

import com.tcc.doapet.model.dto.request.OrderRequest;
import com.tcc.doapet.model.dto.request.OrderRequestUpdate;
import com.tcc.doapet.model.dto.response.OrderResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.net.URI;

public interface OrderService {

    URI save(Long id, OrderRequest orderRequest);

    Page<OrderResponse> findAll(Long id, Pageable pageable);

    OrderResponse findOne(Long ongId, Long orderId);

    OrderResponse update(Long ongId, Long orderId, OrderRequestUpdate orderRequest);

    OrderResponse cancelOrder(Long ongId, Long orderId);
}
