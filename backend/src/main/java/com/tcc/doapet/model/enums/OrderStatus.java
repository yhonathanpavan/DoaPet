package com.tcc.doapet.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum OrderStatus {
    FINALIZED("product"),
    PENDING("pending"),
    CANCELED("canceled");

    private final String value;

    OrderStatus(String value){
        this.value = value;
    }

    @JsonCreator
    public static OrderStatus fromValue(String value){
        for (OrderStatus orderStatus : OrderStatus.values()){
            if(orderStatus.value.equalsIgnoreCase(value)){
                return orderStatus;
            }
        }
        return null;
    }
}
