package com.tcc.doapet.service;

import com.tcc.doapet.model.dto.request.AssistanceRequest;
import com.tcc.doapet.model.dto.response.AssistanceResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.net.URI;

public interface AssistanceService {

    Page<AssistanceResponse> getAll(Pageable pageable);

    AssistanceResponse getById(Long id);

    URI create(AssistanceRequest assistanceRequest);

    AssistanceResponse updateById(Long id, AssistanceRequest assistanceRequest);

    AssistanceResponse updateStatus(Long id);
}
