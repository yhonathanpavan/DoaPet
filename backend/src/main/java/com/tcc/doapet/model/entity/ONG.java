package com.tcc.doapet.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tcc.doapet.helper.TypesOfProfiles;
import com.tcc.doapet.model.User;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
public class ONG extends User {

    @JsonProperty("cnpj")
    private String cnpj;

    @JsonProperty("pix")
    private String pix;

    @JsonProperty("president_name")
    private String presidentName;

    @JsonProperty("biography")
    private String biography;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Profile> profiles = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.profiles;
    }

    @Override
    public String getUsername() {
        return this.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @PrePersist
    public void prePersistData(){
        super.setStatus(true);
        this.setProfiles(TypesOfProfiles.getOngProfile());
    }
}
