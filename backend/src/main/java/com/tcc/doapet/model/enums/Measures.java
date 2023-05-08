package com.tcc.doapet.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Measures {
    UNITS("units"),
    METERS("meters"),
    KILOGRAMS("kilograms"),
    LITERS("liters");

    private final String value;

    Measures(String value){
        this.value = value;
    }

    @JsonCreator
    public static Measures fromValue(String value){
        for (Measures measures : Measures.values()){
            if(measures.value.equalsIgnoreCase(value)){
                return measures;
            }
        }
        return null;
    }
}
