package com.tcc.doapet.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tcc.doapet.model.enums.OrderStatus;
import com.tcc.doapet.model.enums.PriorityLevelStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "TB_ORDER")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ONG_ID")
    private ONG ong;

    @ManyToOne
    @JoinColumn(name = "DONOR_ID")
    private Donor donor;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "ASSISTANCE_ID")
    private Assistance assistance;

    @Enumerated(value = EnumType.STRING)
    @JsonProperty("order_status")
    private OrderStatus orderStatus;

    private LocalDate date;

    @JsonProperty("start_date_assistance")
    private LocalDateTime startDateAssistance;

    @JsonProperty("completion_date_assistance")
    private LocalDateTime completionDateAssistance;

    @Enumerated(value = EnumType.STRING)
    @JsonProperty("priority_level_status")
    private PriorityLevelStatus priorityLevelStatus;

    private Integer quantity;

    @JsonProperty("remaining_quantity")
    private Integer remainingQuantity;

    @JsonProperty("intentions_quantity")
    private Integer intentionsQuantity;

    @JsonProperty("delivered_quantity")
    private Integer deliveredQuantity;

    @JsonProperty("total_price")
    private BigDecimal totalPrice;

    @PrePersist
    private void prePersistFunction(){
        date = LocalDate.now();
        orderStatus = OrderStatus.PENDING;
    }
}
