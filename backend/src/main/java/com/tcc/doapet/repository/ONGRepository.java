package com.tcc.doapet.repository;

import com.tcc.doapet.model.entity.ONG;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ONGRepository extends JpaRepository<ONG, Long> {

    Optional<ONG> findByEmail(String email);

}
