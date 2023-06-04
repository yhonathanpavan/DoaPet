package com.tcc.doapet.model.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tcc.doapet.model.enums.OrderStatus;
import com.tcc.doapet.model.enums.PriorityLevelStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderResponse {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("ong")
    private ONGResponse ong;

    @JsonProperty("donor")
    private DonorResponse donor;

    @JsonProperty("product")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ProductResponse product;

    @JsonProperty("assistance")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private AssistanceResponse assistance;

    @JsonProperty("order_status")
    private OrderStatus orderStatus;

    @JsonProperty("date")
    private LocalDate date;

    @JsonProperty("priority_level_status")
    private PriorityLevelStatus priorityLevelStatus;

    @JsonProperty("quantity")
    private Integer quantity;

    @JsonProperty("total_price")
    private BigDecimal totalPrice;

}
