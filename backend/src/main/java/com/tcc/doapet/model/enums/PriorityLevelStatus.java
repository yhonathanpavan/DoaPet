package com.tcc.doapet.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public enum PriorityLevelStatus {
    @JsonProperty("Alto")
    HIGH("high"),
    @JsonProperty("Médio")
    MEDIUM("medium"),
    @JsonProperty("Baixo")
    LOW("low");


    private final String value;
    PriorityLevelStatus(String value){
        this.value = value;
    }

    @JsonCreator
    public static PriorityLevelStatus fromValue(String value){
        for (PriorityLevelStatus priorityLevelStatus: PriorityLevelStatus.values()){
            if(priorityLevelStatus.value.equalsIgnoreCase(value)){
                return priorityLevelStatus;
            }
        }
        return null;
    }
}
