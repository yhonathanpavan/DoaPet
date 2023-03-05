package com.tcc.doapet.model.entity;

import com.tcc.doapet.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Donor extends User {

    private String cpf;

    private LocalDate birthdate;

}
