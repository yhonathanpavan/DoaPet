package com.tcc.doapet.service.impl;

import com.tcc.doapet.model.dto.request.OrderRequest;
import com.tcc.doapet.model.dto.response.OrderResponse;
import com.tcc.doapet.model.entity.Order;
import com.tcc.doapet.model.enums.OrderStatus;
import com.tcc.doapet.repository.AssistanceRepository;
import com.tcc.doapet.repository.ONGRepository;
import com.tcc.doapet.repository.OrderRepository;
import com.tcc.doapet.repository.ProductRepository;
import com.tcc.doapet.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;
import java.net.URI;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final ModelMapper mapper;

    private final OrderRepository orderRepository;

    private final ONGRepository ongRepository;

    private final ProductRepository productRepository;

    private final AssistanceRepository assistanceRepository;

    @Override
    public URI save(Long id, OrderRequest orderRequest) {
        Order order = mapper.map(orderRequest, Order.class);
        order.setOng(ongRepository.findById(id).orElseThrow(NotFoundException::new));
        if (Objects.nonNull(orderRequest.getProductId())) {
            order.setProduct(productRepository.findById(orderRequest.getProductId()).orElseThrow(NotFoundException::new));
        }
        else if (Objects.nonNull(orderRequest.getAssistanceId())) {
            order.setAssistance(assistanceRepository.findById(orderRequest.getAssistanceId()).orElseThrow(NotFoundException::new));
        }
        else {
            throw new BadRequestException("Enter product ID or assistance ID");
        }
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").build(orderRepository.save(order).getId());
    }

    @Override
    public Page<OrderResponse> findAll(Long id, Pageable pageable) {
        Page<Order> orders = orderRepository.findAllByOngId(id, pageable);
        return orders.map(e -> mapper.map(e, OrderResponse.class));
    }

    @Override
    public OrderResponse findOne(Long ongId, Long orderId) {
        return mapper.map(findOrderByOngId(ongId, orderId), OrderResponse.class);
    }

    @Override
    public OrderResponse update(Long ongId, Long orderId, OrderRequest orderRequest) {
        Order order = findOrderByOngId(ongId, orderId);
        mapper.map(orderRequest, order);
        order.setId(orderId);
        return mapper.map(orderRepository.save(order), OrderResponse.class);
    }

    public Order findOrderByOngId(Long ongId, Long orderId){
        return orderRepository.findByIdAndOngId(orderId, ongId).orElseThrow(NotFoundException::new);
    }
}
