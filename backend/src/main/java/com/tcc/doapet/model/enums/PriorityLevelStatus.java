package com.tcc.doapet.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public enum PriorityLevelStatus {
    @JsonProperty("Alto")
    HIGH(List.of("high", "Alto")),
    @JsonProperty("Médio")
    MEDIUM(List.of("medium", "Médio")),
    @JsonProperty("Baixo")
    LOW(List.of("low", "Baixo"));

    private final List<String> values;

    PriorityLevelStatus(List<String> values){
        this.values = values;
    }

    @JsonCreator
    public static PriorityLevelStatus fromValue(String value){
        for (PriorityLevelStatus priorityLevelStatus: PriorityLevelStatus.values()){
            if(priorityLevelStatus.values.contains(value)){
                return priorityLevelStatus;
            }
        }
        return null;
    }
}
