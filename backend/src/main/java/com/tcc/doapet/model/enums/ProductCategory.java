package com.tcc.doapet.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum ProductCategory {
    FOOD("food"),
    HEALTH("health"),
    TOOL("tool");

    private final String value;
    ProductCategory(String value){
        this.value = value;
    }

    @JsonCreator
    public static ProductCategory fromValue(String value){
        for (ProductCategory productCategory: ProductCategory.values()){
            if(productCategory.value.equalsIgnoreCase(value)){
                return productCategory;
            }
        }
        return null;
    }
}
