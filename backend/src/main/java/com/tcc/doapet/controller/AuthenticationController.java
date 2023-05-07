package com.tcc.doapet.controller;

import com.tcc.doapet.model.dto.request.LoginRequest;
import com.tcc.doapet.model.dto.response.LoginTokenResponse;
import com.tcc.doapet.service.TokenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;

    private final TokenService tokenService;

    @PostMapping
    public ResponseEntity<LoginTokenResponse> auth(@RequestBody @Valid LoginRequest loginRequest){
        var usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword());

        var authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        var token = tokenService.generateToken(authentication);

        return ResponseEntity.ok(LoginTokenResponse.builder().type("Bearer").token(token).build());
    }


}
