package com.tcc.doapet.controller;

import com.tcc.doapet.model.dto.request.LoginRequest;
import com.tcc.doapet.model.dto.response.LoginTokenResponse;
import com.tcc.doapet.service.TokenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;

    private final TokenService tokenService;

    @CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST}, allowedHeaders = "*")
    @PostMapping
    public ResponseEntity<LoginTokenResponse> auth(@RequestBody @Valid LoginRequest loginRequest){
        var usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword());

        var authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        var token = tokenService.generateToken(authentication);
        var userId = tokenService.getUserIdFromToken(token);

        return ResponseEntity.ok(LoginTokenResponse.builder()
                .authenticatedUserId(userId)
                .type("Bearer")
                .token(token)
                .build());
    }


}
