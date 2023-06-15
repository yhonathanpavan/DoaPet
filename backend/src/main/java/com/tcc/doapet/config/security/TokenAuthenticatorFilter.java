package com.tcc.doapet.config.security;

import com.auth0.jwt.JWT;
import com.tcc.doapet.model.User;
import com.tcc.doapet.repository.DonorRepository;
import com.tcc.doapet.repository.ONGRepository;
import com.tcc.doapet.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.NotFoundException;
import java.io.IOException;


@RequiredArgsConstructor
public class TokenAuthenticatorFilter extends OncePerRequestFilter {

    private final TokenService tokenService;

    private final ONGRepository ongRepository;

    private final DonorRepository donorRepository;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String tokenFromHeader = getTokenFromHeader(request);

        boolean tokenValid = tokenService.isTokenValid(tokenFromHeader, request);

        if (tokenValid) {
            this.authenticate(tokenFromHeader);
        }

        filterChain.doFilter(request, response);

    }

    private String getTokenFromHeader(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        if(token != null && token.startsWith("Bearer ")){
            return token.substring(7);
        }
        return null;
    }

    private void authenticate(String tokenFromHeader){
        Long authenticatedUserId = tokenService.getUserIdFromToken(tokenFromHeader);

        var authenticatedUserClassType = JWT.decode(tokenFromHeader).getClaim("classType").asString();

        User user = null;
        if(authenticatedUserClassType.equals("ONG"))
            user = ongRepository.findById(authenticatedUserId).orElseThrow(NotFoundException::new);

        if(authenticatedUserClassType.equals("DONOR"))
            user = donorRepository.findById(authenticatedUserId).orElseThrow(NotFoundException::new);

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

    }
}
