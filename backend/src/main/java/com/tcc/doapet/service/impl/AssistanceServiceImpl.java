package com.tcc.doapet.service.impl;

import com.tcc.doapet.model.dto.request.AssistanceRequest;
import com.tcc.doapet.model.dto.response.AssistanceResponse;
import com.tcc.doapet.model.entity.Assistance;
import com.tcc.doapet.model.entity.ONG;
import com.tcc.doapet.model.enums.AssistanceCategory;
import com.tcc.doapet.repository.AssistanceRepository;
import com.tcc.doapet.repository.ONGRepository;
import com.tcc.doapet.service.AssistanceService;
import com.tcc.doapet.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.ws.rs.ForbiddenException;
import javax.ws.rs.NotFoundException;
import java.net.URI;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AssistanceServiceImpl implements AssistanceService {

    private final TokenService tokenService;
    private final ONGRepository ongRepository;
    private final AssistanceRepository assistanceRepository;
    private final ModelMapper modelMapper;

    @Override
    public Page<AssistanceResponse> getAll(Pageable pageable, String authorization) {
        var ongId = getOngIdByToken(authorization);
        var assistanceEntity = assistanceRepository.findAllByOngId(pageable, ongId);
        return assistanceEntity.map(e -> modelMapper.map(e, AssistanceResponse.class));
    }

    @Override
    public AssistanceResponse getById(Long id, String authorization) {
        var assistanceEntity = findAssistanceById(id);
        validateIfTheAuthenticatedONGBelongsToAssistance(assistanceEntity, authorization);
        return modelMapper.map(assistanceEntity, AssistanceResponse.class);
    }

    @Override
    public List<AssistanceCategory> getAssistanceCategories() {
        return List.of(AssistanceCategory.values());
    }

    @Override
    public URI create(AssistanceRequest assistanceRequest, String authorization) {
        var ong = getOngByToken(authorization);
        var assistanceEntity = modelMapper.map(assistanceRequest, Assistance.class);
        assistanceEntity.setStatus(Boolean.TRUE);
        assistanceEntity.setOng(ong);
        assistanceRepository.save(assistanceEntity);

        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").build(assistanceEntity.getId());
    }

    @Override
    public AssistanceResponse updateById(Long id, AssistanceRequest assistanceRequest, String authorization) {
        var assistanceEntity = findAssistanceById(id);
        validateIfTheAuthenticatedONGBelongsToAssistance(assistanceEntity, authorization);
        modelMapper.map(assistanceRequest, assistanceEntity);
        assistanceRepository.save(assistanceEntity);

        return modelMapper.map(assistanceEntity, AssistanceResponse.class);
    }

    @Override
    public AssistanceResponse updateStatus(Long id, String authorization) {
        Assistance assistance = findAssistanceById(id);
        validateIfTheAuthenticatedONGBelongsToAssistance(assistance, authorization);
        assistance.setStatus(!assistance.getStatus());
        return modelMapper.map(assistanceRepository.save(assistance), AssistanceResponse.class);
    }


    protected Assistance findAssistanceById(Long id){
        return assistanceRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    private ONG getOngByToken(String authorization){
        var token = authorization.substring(7);
        var ongId = tokenService.getUserIdFromToken(token);
        return ongRepository.findById(ongId).orElseThrow(NotFoundException::new);
    }

    private Long getOngIdByToken(String authorization){
        var token = authorization.substring(7);
        return tokenService.getUserIdFromToken(token);
    }

    private void validateIfTheAuthenticatedONGBelongsToAssistance(Assistance assistance, String authorization){
        var ongId = getOngIdByToken(authorization);
        if(!assistance.getOng().getId().equals(ongId)){
            throw new ForbiddenException();
        }
    }

}
