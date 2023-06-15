package com.tcc.doapet.service;

import com.tcc.doapet.model.dto.request.AssistanceRequest;
import com.tcc.doapet.model.dto.response.AssistanceResponse;
import com.tcc.doapet.model.enums.AssistanceCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.net.URI;
import java.util.List;

public interface AssistanceService {

    Page<AssistanceResponse> getAll(Pageable pageable, String authorization);

    AssistanceResponse getById(Long id, String authorization);

    List<AssistanceCategory> getAssistanceCategories();

    URI create(AssistanceRequest assistanceRequest, String authorization);

    AssistanceResponse updateById(Long id, AssistanceRequest assistanceRequest, String authorization);

    AssistanceResponse updateStatus(Long id, String authorization);

}
