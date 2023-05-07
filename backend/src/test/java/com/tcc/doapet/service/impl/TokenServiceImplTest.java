package com.tcc.doapet.service.impl;

import com.tcc.doapet.factory.DonorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.test.util.ReflectionTestUtils;

import javax.servlet.http.HttpServletRequest;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TokenServiceImplTest {

    @InjectMocks
    private TokenServiceImpl tokenService;

    private String invalidToken = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJEb2FQZXQgQXBwbGljYXRpb24iLCJzdWIiOiIxIiwiaWF0IjoxNjgxNjkyOTg2LCJleHAiOjE2ODE2OTY1ODYsImNsYXNzVHlwZSI6IkRPTk9SIn0.xkg_0ZycUof3n6Gbd2zbvM0S4SYToUlA5pmFg1gqyRM";

    private String validToken;

    private Authentication authentication;

    @BeforeEach
    void setUp(){
        ReflectionTestUtils.setField(tokenService, "expirationInMinutes", "60");
        ReflectionTestUtils.setField(tokenService, "secret", "c3RyaW5nw6dpbmlzdHJh");

        var donor = DonorFactory.getDonor();
        authentication = new UsernamePasswordAuthenticationToken(donor, null);
        validToken = tokenService.generateToken(authentication);
    }

    @Test
    void generateToken() {
        var token = tokenService.generateToken(authentication);

        assertNotNull(token);
    }

    @Test
    void getUserIdFromToken() {
        var userIdFromToken = tokenService.getUserIdFromToken(validToken);

        assertNotNull(userIdFromToken);
        assertEquals(1L, userIdFromToken);
    }

    @Test
    void whenCallMethodToVerifyIfisTokenValidThenReturnTrue() {
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.setServletPath("/test");

        var isTokenValid = tokenService.isTokenValid(validToken, httpServletRequest);

        assertTrue(isTokenValid);
    }

    @Test
    void whenCallMethodToVerifyIfisTokenValidThenReturnFalse() {
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.setServletPath("/test");
        var isTokenValid = tokenService.isTokenValid(invalidToken, httpServletRequest);

        assertFalse(isTokenValid);
    }
}