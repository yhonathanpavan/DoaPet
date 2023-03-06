package com.tcc.doapet.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum PriorityLevelStatus {
    HIGH("high"),
    MEDIUM("medium"),
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
