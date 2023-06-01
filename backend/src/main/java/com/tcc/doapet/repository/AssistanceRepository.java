package com.tcc.doapet.repository;

import com.tcc.doapet.model.entity.Assistance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssistanceRepository extends JpaRepository<Assistance, Long> {
    Page<Assistance> findAllByOngId(Pageable pageable, Long ongId);
}
