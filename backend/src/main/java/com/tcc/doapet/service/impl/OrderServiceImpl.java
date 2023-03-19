package com.tcc.doapet.service.impl;

import com.tcc.doapet.model.dto.request.OrderRequest;
import com.tcc.doapet.model.dto.response.OrderResponse;
import com.tcc.doapet.model.entity.Order;
import com.tcc.doapet.repository.AssistanceRepository;
import com.tcc.doapet.repository.ONGRepository;
import com.tcc.doapet.repository.OrderRepository;
import com.tcc.doapet.repository.ProductRepository;
import com.tcc.doapet.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;
import java.net.URI;
import java.time.LocalDate;
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
    public URI save(Long ongId, OrderRequest orderRequest) {

        mapper.addMappings(new PropertyMap<OrderRequest, Order>() {
            @Override
            protected void configure() {
                skip(destination.getId());
            }
        });

        Order order = mapper.map(orderRequest, Order.class);
        if (Objects.nonNull(orderRequest.getProductId())) {
            order.setProduct(productRepository.findById(orderRequest.getProductId()).orElseThrow(NotFoundException::new));
        }
        else if (Objects.nonNull(orderRequest.getAssistanceId())) {
            order.setAssistance(assistanceRepository.findById(orderRequest.getAssistanceId()).orElseThrow(NotFoundException::new));
        }
        else {
            throw new BadRequestException("Enter product ID or assistance ID");
        }
        order.setOng(ongRepository.findById(ongId).orElseThrow(NotFoundException::new));
        order.setDate(LocalDate.now());

        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").build(orderRepository.save(order).getId());
    }

    @Override
    public Page<OrderResponse> findAll(Long ongId, Pageable pageable) {
        Page<Order> orders = orderRepository.findAllByOngId(ongId, pageable);
        return orders.map(e -> mapper.map(e, OrderResponse.class));
    }

    @Override
    public OrderResponse findOne(Long ongId, Long orderId) {
        return mapper.map(findOrderByOngId(ongId, orderId), OrderResponse.class);
    }

    @Override
    public OrderResponse update(Long ongId, Long orderId, OrderRequest orderRequest) {
        mapper.addMappings(new PropertyMap<OrderRequest, Order>() {
            @Override
            protected void configure() {
                skip(destination.getId());
            }
        });

        Order order = findOrderByOngId(ongId, orderId);
        mapper.map(orderRequest, order);
        order.setId(orderId);
        return mapper.map(orderRepository.save(order), OrderResponse.class);
    }

    public Order findOrderByOngId(Long ongId, Long orderId){
        return orderRepository.findByIdAndOngId(orderId, ongId).orElseThrow(NotFoundException::new);
    }
}