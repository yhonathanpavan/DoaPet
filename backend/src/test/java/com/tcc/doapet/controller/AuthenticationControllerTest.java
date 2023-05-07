package com.tcc.doapet.controller;

import com.tcc.doapet.factory.DonorFactory;
import com.tcc.doapet.factory.ONGFactory;
import com.tcc.doapet.factory.ProductFactory;
import com.tcc.doapet.model.dto.request.LoginRequest;
import com.tcc.doapet.service.TokenService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AuthenticationControllerTest {

    @InjectMocks
    private AuthenticationController authenticationController;

    @Mock
    private TokenService tokenService;

    @Spy
    private AuthenticationManager authenticationManager;

    private String token;

    @BeforeEach
    void setUp(){
        var donor = DonorFactory.getDonor();
        Authentication authentication = new UsernamePasswordAuthenticationToken(donor, null);
        token = "Bearer "+tokenService.generateToken(authentication);
    }

    @Test
    void whenPostCredentialsThenReturnALoginTokenResponse(){
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail(DonorFactory.getDonor().getEmail());
        loginRequest.setPassword(DonorFactory.getDonor().getPassword());

        when(tokenService.generateToken(any())).thenReturn(token);

        var loginTokenResponse = authenticationController.auth(loginRequest);

        assertNotNull(loginTokenResponse.getBody());
    }


}
