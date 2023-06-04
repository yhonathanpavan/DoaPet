package com.tcc.doapet.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public enum OrderStatus {
    @JsonProperty("Finalizado")
    FINALIZED(List.of("finalized", "Finalizado")),
    @JsonProperty("Pendente")
    PENDING(List.of("pending", "Pendente")),
    @JsonProperty("Cancelado")
    CANCELED(List.of("canceled", "Cancelado"));

    private final List<String> values;

    OrderStatus(List<String> values){
        this.values = values;
    }

    @JsonCreator
    public static OrderStatus fromValue(String value){
        for (OrderStatus orderStatus : OrderStatus.values()){
            if(orderStatus.values.contains(value)){
                return orderStatus;
            }
        }
        return null;
    }
}
