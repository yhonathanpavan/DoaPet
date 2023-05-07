package com.tcc.doapet.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public enum Measures {
    @JsonProperty("Unidade")
    UNITS(List.of("units", "Unidade")),
    @JsonProperty("Metros")
    METERS(List.of("meters", "Metros")),
    @JsonProperty("Quilograma")
    KILOGRAMS(List.of("kilograms", "Quilograma")),
    @JsonProperty("Litros")
    LITERS(List.of("liters", "Litros" ));

    private final List<String> values;

    Measures(List<String> values){
        this.values = values;
    }

    @JsonCreator
    public static Measures fromValue(String value){
        for (Measures measures : Measures.values()){
            if(measures.values.contains(value)){
                return measures;
            }
        }
        return null;
    }
}
