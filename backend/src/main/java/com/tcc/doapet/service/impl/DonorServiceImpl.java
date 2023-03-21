package com.tcc.doapet.service.impl;

import com.tcc.doapet.model.dto.request.DonorRequest;
import com.tcc.doapet.model.dto.response.DonorResponse;
import com.tcc.doapet.model.entity.Donor;
import com.tcc.doapet.repository.DonorRepository;
import com.tcc.doapet.service.DonorService;
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
public class DonorServiceImpl implements DonorService {

    private final DonorRepository donorRepository;

    private final ModelMapper modelMapper;

    @Override
    public Page<DonorResponse> getAll(Pageable pageable) {
        var donorEntity = donorRepository.findAll(pageable);
        return donorEntity.map(e -> modelMapper.map(e, DonorResponse.class));
    }

    @Override
    public DonorResponse getById(Long id) {
        var donorEntity = findDonorById(id);
        return modelMapper.map(donorEntity, DonorResponse.class);
    }

    @Override
    public URI create(DonorRequest donorRequest) {
        var donorEntity = modelMapper.map(donorRequest, Donor.class);
        donorEntity.setStatus(Boolean.TRUE);
        donorRepository.save(donorEntity);

        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").build(donorEntity.getId());
    }

    @Override
    public DonorResponse updateById(Long id, DonorRequest donorRequest) {
        var donorEntity = findDonorById(id);
        modelMapper.map(donorRequest, donorEntity);
        donorRepository.save(donorEntity);

        return modelMapper.map(donorEntity, DonorResponse.class);
    }

    @Override
    public DonorResponse updateStatus(Long id) {
        Donor donor = findDonorById(id);
        donor.setStatus(!donor.getStatus());
        return modelMapper.map(donorRepository.save(donor), DonorResponse.class);
    }

    protected Donor findDonorById(Long id){
        return donorRepository.findById(id).orElseThrow(NotFoundException::new);
    }
}
