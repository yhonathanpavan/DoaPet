package com.tcc.doapet.helper;

import com.tcc.doapet.model.entity.Profile;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TypesOfProfiles {

    public static Set<Profile> getAdminProfile(){
        return Set.of(Profile.builder()
                .id(1L)
                .name("ROLE_ADMIN")
                .build());
    }

    public static Set<Profile> getOngProfile(){
        return Set.of(Profile.builder()
                .id(2L)
                .name("ROLE_ONG")
                .build());
    }

    public static Set<Profile> getDonorProfile(){
        return Set.of(Profile.builder()
                .id(3L)
                .name("ROLE_DONOR")
                .build());
    }
}
