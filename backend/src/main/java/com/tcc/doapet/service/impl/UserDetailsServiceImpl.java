package com.tcc.doapet.service.impl;

import com.tcc.doapet.repository.DonorRepository;
import com.tcc.doapet.repository.ONGRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final ONGRepository ongRepository;
    private final DonorRepository donorRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var ongUser = ongRepository.findByEmail(username);
        var donorUser = donorRepository.findByEmail(username);

        if(ongUser.isPresent()){
            return ongUser.get();
        }
        if(donorUser.isPresent()){
            return donorUser.get();
        }

        throw new UsernameNotFoundException("User not found in our database");
    }
}
