package com.tcc.doapet.service;

import com.tcc.doapet.model.dto.request.DonorRequest;
import com.tcc.doapet.model.dto.response.DonorResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.net.URI;

public interface DonorService {

    Page<DonorResponse> getAll(Pageable pageable);

    DonorResponse getById(Long id);

    URI create(DonorRequest donorRequest);

    DonorResponse updateById(Long id, DonorRequest donorRequest);

}
