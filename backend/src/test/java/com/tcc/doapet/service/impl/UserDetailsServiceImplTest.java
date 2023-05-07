package com.tcc.doapet.service.impl;

import com.tcc.doapet.factory.DonorFactory;
import com.tcc.doapet.factory.ONGFactory;
import com.tcc.doapet.model.entity.Donor;
import com.tcc.doapet.model.entity.ONG;
import com.tcc.doapet.repository.DonorRepository;
import com.tcc.doapet.repository.ONGRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.ws.rs.WebApplicationException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserDetailsServiceImplTest {

    @InjectMocks
    private UserDetailsServiceImpl userDetailsService;

    @Mock
    private ONGRepository ongRepository;

    @Mock
    private DonorRepository donorRepository;


    @Test
    void loadONGUserByUsername() {
        when(ongRepository.findByEmail(anyString())).thenReturn(Optional.of(ONGFactory.getONG()));

        var actualUserFound = userDetailsService.loadUserByUsername("focinhoscarinhosos@email.com");

        assertNotNull(actualUserFound);
        assertEquals(ONG.class, actualUserFound.getClass());
    }

    @Test
    void loadDonorUserByUsername() {
        when(donorRepository.findByEmail(anyString())).thenReturn(Optional.of(DonorFactory.getDonor()));

        var actualUserFound = userDetailsService.loadUserByUsername("eduardo.pedro.ramos@multmed.com.br");

        assertNotNull(actualUserFound);
        assertEquals(Donor.class, actualUserFound.getClass());
    }

    @Test
    void throwAnExceptionWhenNotFindUserByUsername() {
        var usernameNotFoundException = new UsernameNotFoundException("null");
        when(ongRepository.findByEmail(anyString())).thenReturn(Optional.empty());
        when(donorRepository.findByEmail(anyString())).thenReturn(Optional.empty());

        try{
            var actualUserFound = userDetailsService.loadUserByUsername("eduardo.pedro.ramos@multmed.com.br");
        }catch(UsernameNotFoundException ex){
            usernameNotFoundException = ex;
        }
        assertEquals("User not found in our database", usernameNotFoundException.getMessage());
    }
}