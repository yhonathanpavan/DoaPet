package com.tcc.doapet.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@MappedSuperclass
public abstract class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    @JsonProperty("phone_number")
    private String phoneNumber;

    private String street;

    private String number;

    private String neighborhood;

    private String city;

    private String state;

    @JsonProperty("profile_picture")
    private String profilePicture;

    private Boolean status;

}
