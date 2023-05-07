package com.tcc.doapet.repository;

import com.tcc.doapet.model.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Page<Order> findAllByOngId(Long id, Pageable pageable);

    Optional<Order> findByIdAndOngId(Long orderId, Long ongId);
}
