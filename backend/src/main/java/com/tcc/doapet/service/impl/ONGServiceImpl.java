package com.tcc.doapet.service.impl;

import com.tcc.doapet.model.dto.request.ONGRequest;
import com.tcc.doapet.model.dto.response.ONGResponse;
import com.tcc.doapet.model.entity.ONG;
import com.tcc.doapet.repository.ONGRepository;
import com.tcc.doapet.service.ONGService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.ws.rs.NotFoundException;
import java.net.URI;

@Service
@RequiredArgsConstructor
public class ONGServiceImpl implements ONGService {

    private final ModelMapper modelMapper;

    private final ONGRepository ongRepository;

    @Override
    public Page<ONGResponse> getAll(Pageable pageable) {
        var ongEntity = ongRepository.findAll(pageable);
        return ongEntity.map(e -> modelMapper.map(e, ONGResponse.class));
    }

    @Override
    public ONGResponse getById(Long id) {
        var ongEntity = ongRepository.findById(id).orElseThrow(NotFoundException::new);
        return modelMapper.map(ongEntity, ONGResponse.class);
    }

    @Override
    public URI create(ONGRequest ongRequest) {
        var ongEntity = modelMapper.map(ongRequest, ONG.class);

        ongRepository.save(ongEntity);

        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").build(ongEntity.getId());
    }

    @Override
    public ONGResponse updateById(Long id, ONGRequest ongRequest) {
        var ongEntity = ongRepository.findById(id).orElseThrow(NotFoundException::new);
        modelMapper.map(ongRequest, ongEntity);
        ongRepository.save(ongEntity);

        return modelMapper.map(ongEntity, ONGResponse.class);
    }
}
