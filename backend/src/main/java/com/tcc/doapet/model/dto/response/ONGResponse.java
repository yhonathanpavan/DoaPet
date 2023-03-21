package com.tcc.doapet.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ONGResponse {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    private String email;

    @JsonProperty("phone_number")
    private String phoneNumber;

    @JsonProperty("street")
    private String street;

    @JsonProperty("number")
    private String number;

    @JsonProperty("neighborhood")
    private String neighborhood;

    @JsonProperty("city")
    private String city;

    @JsonProperty("state")
    private String state;

    @JsonProperty("cnpj")
    private String cnpj;

    @JsonProperty("pix")
    private String pix;

    @JsonProperty("president_name")
    private String presidentName;

    @JsonProperty("biography")
    private String biography;

    @JsonProperty("profile_picture")
    private String profilePicture;

    @JsonProperty("status")
    private Boolean status;

}
