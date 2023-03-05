package com.tcc.doapet.service;

import com.tcc.doapet.model.dto.request.ONGRequest;
import com.tcc.doapet.model.dto.response.ONGResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.net.URI;

public interface ONGService {

    Page<ONGResponse> getAll(Pageable pageable);

    ONGResponse getById(Long id);

    URI create(ONGRequest ongRequest);

    ONGResponse updateById(Long id, ONGRequest ongRequest);

}
