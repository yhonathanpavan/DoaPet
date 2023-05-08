package com.tcc.doapet.service.impl;

import com.tcc.doapet.model.dto.request.AssistanceRequest;
import com.tcc.doapet.model.dto.response.AssistanceResponse;
import com.tcc.doapet.model.entity.Assistance;
import com.tcc.doapet.repository.AssistanceRepository;
import com.tcc.doapet.service.AssistanceService;
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
public class AssistanceServiceImpl implements AssistanceService {

    private final AssistanceRepository assistanceRepository;

    private final ModelMapper modelMapper;

    @Override
    public Page<AssistanceResponse> getAll(Pageable pageable) {
        var assistanceEntity = assistanceRepository.findAll(pageable);
        return assistanceEntity.map(e -> modelMapper.map(e, AssistanceResponse.class));
    }

    @Override
    public AssistanceResponse getById(Long id) {
        var assistanceEntity = findAssistanceById(id);
        return modelMapper.map(assistanceEntity, AssistanceResponse.class);
    }

    @Override
    public URI create(AssistanceRequest assistanceRequest) {
        var assistanceEntity = modelMapper.map(assistanceRequest, Assistance.class);
        assistanceEntity.setStatus(Boolean.TRUE);
        assistanceRepository.save(assistanceEntity);

        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").build(assistanceEntity.getId());
    }

    @Override
    public AssistanceResponse updateById(Long id, AssistanceRequest assistanceRequest) {
        var assistanceEntity = findAssistanceById(id);
        modelMapper.map(assistanceRequest, assistanceEntity);
        assistanceRepository.save(assistanceEntity);

        return modelMapper.map(assistanceEntity, AssistanceResponse.class);
    }

    @Override
    public AssistanceResponse updateStatus(Long id) {
        Assistance assistance = findAssistanceById(id);
        assistance.setStatus(!assistance.getStatus());
        return modelMapper.map(assistanceRepository.save(assistance), AssistanceResponse.class);
    }

    protected Assistance findAssistanceById(Long id){
        return assistanceRepository.findById(id).orElseThrow(NotFoundException::new);
    }

}
