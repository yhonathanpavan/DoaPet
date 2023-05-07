package com.tcc.doapet.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public enum ProductCategory {
    @JsonProperty("Comida")
    FOOD(List.of("food", "Comida")),
    @JsonProperty("Saúde")
    HEALTH(List.of("health", "Saúde")),
    @JsonProperty("Ferramenta")
    TOOL(List.of("tool", "Ferramenta"));

    private final List<String> values;

    ProductCategory(List<String> values){
        this.values = values;
    }

    @JsonCreator
    public static ProductCategory fromValue(String value){
        for (ProductCategory productCategory: ProductCategory.values()){
            if(productCategory.values.contains(value)){
                return productCategory;
            }
        }
        return null;
    }
}
