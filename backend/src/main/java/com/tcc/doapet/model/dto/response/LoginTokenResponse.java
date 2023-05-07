package com.tcc.doapet.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class LoginTokenResponse {


    private String token;

    private String type;
}
