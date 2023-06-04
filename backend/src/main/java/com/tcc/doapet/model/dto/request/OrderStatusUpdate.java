package com.tcc.doapet.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tcc.doapet.model.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderStatusUpdate {

    @JsonProperty("status")
    @NotNull
    private OrderStatus status;

}
