package com.tcc.doapet.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tcc.doapet.model.enums.Measures;
import com.tcc.doapet.model.enums.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

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

    @Enumerated(value = EnumType.STRING)
    @JsonProperty("measure")
    private Measures measure;

    @Enumerated(value = EnumType.STRING)
    @JsonProperty("product_category")
    private ProductCategory productCategory;

    private BigDecimal price;

    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "ONG_ID")
    private ONG ong;
}
