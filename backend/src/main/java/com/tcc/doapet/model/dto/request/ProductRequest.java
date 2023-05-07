package com.tcc.doapet.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tcc.doapet.model.enums.Measures;
import com.tcc.doapet.model.enums.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductRequest {

    @NotEmpty
    @JsonProperty("name")
    private String name;

    @NotNull
    @JsonProperty("measure")
    private Measures measure;

    @NotNull
    @JsonProperty("product_category")
    private ProductCategory productCategory;

    @NotNull
    @JsonProperty("price")
    private BigDecimal price;

}
