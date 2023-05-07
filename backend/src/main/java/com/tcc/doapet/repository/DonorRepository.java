package com.tcc.doapet.repository;

import com.tcc.doapet.model.entity.Donor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonorRepository extends JpaRepository<Donor, Long> {
}
