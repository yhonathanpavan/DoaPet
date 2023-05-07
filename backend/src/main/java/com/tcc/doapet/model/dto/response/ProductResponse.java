package com.tcc.doapet.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tcc.doapet.model.enums.Measures;
import com.tcc.doapet.model.enums.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductResponse {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("measure")
    private Measures measure;

    @JsonProperty("product_category")
    private ProductCategory productCategory;

    @JsonProperty("price")
    private BigDecimal price;

    @JsonProperty("status")
    private Boolean status;
}
