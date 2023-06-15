package com.tcc.doapet.helper;

import com.auth0.jwt.JWT;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.ws.rs.ForbiddenException;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TokenValidation {

    public static void  validateToken(Long id, String token){
        var  userAuthenticatedId = Long.parseLong(JWT.decode(token.substring(7)).getSubject());

        if(id.equals(userAuthenticatedId)){
            return;
        }
        throw new ForbiddenException();
    }
}
