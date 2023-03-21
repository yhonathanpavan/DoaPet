package com.tcc.doapet.model.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tcc.doapet.model.entity.Assistance;
import com.tcc.doapet.model.entity.Donor;
import com.tcc.doapet.model.entity.ONG;
import com.tcc.doapet.model.entity.Product;
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

    @JsonProperty("start_date_service")
    private LocalDateTime startDateService;

    @JsonProperty("completion_date_service")
    private LocalDateTime completionDateService;

    @JsonProperty("priority_level_status")
    private PriorityLevelStatus priorityLevelStatus;

    @JsonProperty("quantity")
    private Integer quantity;

    @JsonProperty("remaining_quantity")
    private Integer remainingQuantity;

    @JsonProperty("intentions_quantity")
    private Integer intentionsQuantity;

    @JsonProperty("delivered_quantity")
    private Integer deliveredQuantity;

    @JsonProperty("total_price")
    private BigDecimal totalPrice;

}
