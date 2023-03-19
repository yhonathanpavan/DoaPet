package com.tcc.doapet.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ONGRequest {

    @NotBlank
    @JsonProperty("name")
    private String name;

    @NotBlank
    @JsonProperty("email")
    private String email;

    @NotBlank
    @JsonProperty("password")
    private String password;

    @NotBlank
    @JsonProperty("phone_number")
    private String phoneNumber;

    @NotBlank
    @JsonProperty("street")
    private String street;

    @NotBlank
    @JsonProperty("number")
    private String number;

    @NotBlank
    @JsonProperty("neighborhood")
    private String neighborhood;

    @NotBlank
    @JsonProperty("city")
    private String city;

    @NotBlank
    @JsonProperty("state")
    private String state;

    @CNPJ
    @NotBlank
    @JsonProperty("cnpj")
    private String cnpj;

    @NotBlank
    @JsonProperty("pix")
    private String pix;

    @NotBlank
    @JsonProperty("president_name")
    private String presidentName;

    @NotBlank
    @JsonProperty("biography")
    private String biography;

    @NotNull
    @JsonProperty("active")
    private Boolean active;

}
