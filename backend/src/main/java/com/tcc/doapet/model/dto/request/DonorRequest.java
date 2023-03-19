package com.tcc.doapet.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DonorRequest {

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

    @CPF
    @NotBlank
    @JsonProperty("cpf")
    private String cpf;

    @NotNull
    @JsonProperty("birthdate")
    private LocalDate birthdate;

    @NotNull
    @JsonProperty("active")
    private Boolean active;

}
