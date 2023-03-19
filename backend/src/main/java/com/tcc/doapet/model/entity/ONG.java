package com.tcc.doapet.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tcc.doapet.model.User;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
public class ONG extends User {

    private String cnpj;

    private String pix;

    @JsonProperty("president_name")
    private String presidentName;

    private String biography;

}
