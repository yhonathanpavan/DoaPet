package com.tcc.doapet.service.impl;

import com.tcc.doapet.model.User;
import com.tcc.doapet.model.entity.Donor;
import com.tcc.doapet.model.entity.ONG;
import com.tcc.doapet.service.TokenService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.RequestFacade;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class TokenServiceImpl implements TokenService {

    @Value("${security.jwt.expirationInMinutes}")
    private String expirationInMinutes;

    @Value("${security.jwt.secret}")
    private String secret;


    @Override
    public String generateToken(Authentication authentication) {

        var authenticatedUser = (User) authentication.getPrincipal();
        Map<String, Object> claims = new HashMap<>();

        if(authenticatedUser instanceof ONG)
            claims.put("classType", "ONG");
        if(authenticatedUser instanceof Donor)
            claims.put("classType", "DONOR");

        LocalDateTime actualDatePlusMinutes = LocalDateTime.now().plusMinutes(Long.parseLong(expirationInMinutes));

        Date expirationDate = Date.from(actualDatePlusMinutes.atZone(ZoneId.systemDefault()).toInstant());
        Date now = new Date();

        return Jwts.builder()
                .setIssuer("DoaPet Application")
                .setSubject(authenticatedUser.getId().toString())
                .setIssuedAt(now)
                .setExpiration(expirationDate)
                .addClaims(claims)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    @Override
    public Long getUserIdFromToken(String token) {
        Claims body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        return Long.valueOf(body.getSubject());
    }

    @Override
    public Boolean isTokenValid(String token, HttpServletRequest request) {
        try{
            Jwts
            .parser()
            .setSigningKey(secret)
            .parseClaimsJws(token);

            return true;

        }catch(Exception e){
            if(!request.getServletPath().contains("/auth"))
                log.warn(e.getMessage());
            return false;
        }
    }
}
