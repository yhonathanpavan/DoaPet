package com.tcc.doapet.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tcc.doapet.model.enums.PriorityLevelStatus;
import com.tcc.doapet.model.enums.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductResponse {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("unit")
    private String unit;

    @JsonProperty("weight")
    private Double weight;

    @JsonProperty("priority_level_status")
    private PriorityLevelStatus priorityLevelStatus;

    @JsonProperty("product_category")
    private ProductCategory productCategory;

    @JsonProperty("active")
    private Boolean active;
}
