package com.tcc.doapet.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public enum AssistanceCategory {
    @JsonProperty("Estética")
    AESTHETICS(List.of("aesthetics", "Estética")),
    @JsonProperty("Saúde")
    HEALTH (List.of("health", "Saúde"));

    private final List<String> values;

    AssistanceCategory(List<String> values){
        this.values = values;
    }

    @JsonCreator
    public static AssistanceCategory fromValue(String value){
        for (AssistanceCategory assistanceCategory: AssistanceCategory.values()){
            if(assistanceCategory.values.contains(value)){
                return assistanceCategory;
            }
        }
        return null;
    }
}
