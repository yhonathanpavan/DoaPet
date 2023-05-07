package com.tcc.doapet.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public enum AssistanceCategory {
    @JsonProperty("Estética")
    AESTHETICS("aesthetics"),
    @JsonProperty("Saúde")
    HEALTH("health");

    private final String value;
    AssistanceCategory(String value){
        this.value = value;
    }

    @JsonCreator
    public static AssistanceCategory fromValue(String value){
        for (AssistanceCategory assistanceCategory: AssistanceCategory.values()){
            if(assistanceCategory.value.equalsIgnoreCase(value)){
                return assistanceCategory;
            }
        }
        return null;
    }
}
