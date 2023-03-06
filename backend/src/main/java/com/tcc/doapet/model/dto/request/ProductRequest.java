package com.tcc.doapet.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tcc.doapet.model.enums.PriorityLevelStatus;
import com.tcc.doapet.model.enums.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductRequest {

    @NotEmpty
    @JsonProperty("name")
    private String name;

    @NotEmpty
    @JsonProperty("unit")
    private String unit;

    @JsonProperty("weight")
    private Double weight;

    @NotNull
    @JsonProperty("priority_level_status")
    private PriorityLevelStatus priorityLevelStatus;

    @NotNull
    @JsonProperty("product_category")
    private ProductCategory productCategory;

    @JsonProperty("active")
    private Boolean active;
}
