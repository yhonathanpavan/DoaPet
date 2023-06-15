package com.tcc.doapet.service;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

public interface TokenService {

     String generateToken(Authentication authentication);

     Long getUserIdFromToken(String token);

     Boolean isTokenValid(String token, HttpServletRequest request);

}
