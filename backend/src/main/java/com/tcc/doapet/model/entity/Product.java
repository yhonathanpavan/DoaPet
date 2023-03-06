package com.tcc.doapet.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tcc.doapet.model.enums.PriorityLevelStatus;
import com.tcc.doapet.model.enums.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String unit;

    private Double weight;

    @Enumerated(value = EnumType.STRING)
    @JsonProperty("priority_level_status")
    private PriorityLevelStatus priorityLevelStatus;

    @Enumerated(value = EnumType.STRING)
    @JsonProperty("product_category")
    private ProductCategory productCategory;

    private Boolean active;
}
