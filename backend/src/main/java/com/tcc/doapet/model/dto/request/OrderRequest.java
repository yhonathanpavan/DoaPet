package com.tcc.doapet.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tcc.doapet.model.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.FutureOrPresent;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderRequest {

    @JsonProperty("product_id")
    private Long productId;

    @JsonProperty("assistance_id")
    private Long assistanceId;

    @JsonProperty("quantity")
    private Integer quantity;

    @JsonProperty("order_status")
    private OrderStatus orderStatus;

    @FutureOrPresent
    @JsonProperty("start_date_service")
    private LocalDateTime startDateService;

    @FutureOrPresent
    @JsonProperty("completion_date_service")
    private LocalDateTime completionDateService;
}
