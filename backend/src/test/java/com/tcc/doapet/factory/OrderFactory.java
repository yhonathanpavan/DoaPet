package com.tcc.doapet.factory;

import com.tcc.doapet.model.dto.request.OrderRequest;
import com.tcc.doapet.model.dto.request.OrderRequestUpdate;
import com.tcc.doapet.model.dto.response.OrderResponse;
import com.tcc.doapet.model.entity.Order;
import com.tcc.doapet.model.enums.OrderStatus;
import com.tcc.doapet.model.enums.PriorityLevelStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OrderFactory {


    public static OrderRequest getOrderWithNoAssistanceOrProductSaveRequest(){
        return OrderRequest.builder()
                .quantity(1)
                .priorityLevelStatus(PriorityLevelStatus.MEDIUM)
                .build();
    }

    public static OrderRequest getOrderAssistanceSaveRequest(){
        return OrderRequest.builder()
                .assistanceId(1L)
                .quantity(1)
                .priorityLevelStatus(PriorityLevelStatus.MEDIUM)
                .build();
    }

    public static OrderRequestUpdate getOrderAssistanceUpdateRequest(){
        return OrderRequestUpdate.builder()
                .assistanceId(1L)
                .quantity(1)
                .orderStatus(OrderStatus.CANCELED)
                .startDateAssistance(LocalDateTime.parse("1986-04-08T12:30:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME))
                .completionDateAssistance(LocalDateTime.parse("1986-04-08T12:30:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME))
                .priorityLevelStatus(PriorityLevelStatus.MEDIUM)
                .build();
    }



    public static OrderResponse getOrderAssistanceResponse() {
        return OrderResponse.builder()
                .id(1L)
                .ong(ONGFactory.getONGResponse())
                .assistance(AssistanceFactory.getAssistanceResponse())
                .orderStatus(OrderStatus.PENDING)
                .date(LocalDate.of(2023, 3, 16))
                .quantity(1)
                .priorityLevelStatus(PriorityLevelStatus.MEDIUM)
                .totalPrice(AssistanceFactory.getAssistanceResponse().getPrice().multiply(BigDecimal.valueOf(1)))
                .build();
    }

    public static Order getAssistanceOrder(){
        return Order.builder()
                .id(1L)
                .ong(ONGFactory.getONG())
                .assistance(AssistanceFactory.getAssistance())
                .orderStatus(OrderStatus.PENDING)
                .date(LocalDate.of(2023, 3, 16))
                .quantity(1)
                .priorityLevelStatus(PriorityLevelStatus.MEDIUM)
                .totalPrice(AssistanceFactory.getAssistanceResponse().getPrice().multiply(BigDecimal.valueOf(1)))
                .build();
    }

    public static OrderRequest getOrderProductSaveRequest(){
       return OrderRequest.builder()
               .productId(1L)
               .quantity(1)
               .priorityLevelStatus(PriorityLevelStatus.MEDIUM)
               .build();
    }

    public static OrderRequest getOrderProductUpdateRequest(){
        return OrderRequest.builder()
                .productId(1L)
                .quantity(1)
                .orderStatus(OrderStatus.CANCELED)
                .priorityLevelStatus(PriorityLevelStatus.MEDIUM)
                .build();
    }

    public static OrderResponse getOrderProductResponse() {
        return OrderResponse.builder()
                .id(1L)
                .ong(ONGFactory.getONGResponse())
                .product(ProductFactory.getProductResponse())
                .orderStatus(OrderStatus.PENDING)
                .date(LocalDate.of(2023, 3, 16))
                .quantity(1)
                .priorityLevelStatus(PriorityLevelStatus.MEDIUM)
                .totalPrice(AssistanceFactory.getAssistanceResponse().getPrice().multiply(BigDecimal.valueOf(1)))
                .build();

    }

    public static Order getProductOrder(){
        return Order.builder()
                .id(1L)
                .ong(ONGFactory.getONG())
                .product(ProductFactory.getProduct())
                .orderStatus(OrderStatus.PENDING)
                .date(LocalDate.of(2023, 3, 16))
                .quantity(1)
                .priorityLevelStatus(PriorityLevelStatus.MEDIUM)
                .totalPrice(AssistanceFactory.getAssistanceResponse().getPrice().multiply(BigDecimal.valueOf(1)))
                .build();
    }

}
