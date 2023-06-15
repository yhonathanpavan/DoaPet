package com.tcc.doapet.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tcc.doapet.model.enums.AssistanceCategory;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Assistance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(value = EnumType.STRING)
    @JsonProperty("assistance_category")
    private AssistanceCategory assistanceCategory;

    private BigDecimal price;

    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "ONG_ID")
    private ONG ong;
}
