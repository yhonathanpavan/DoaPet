package com.tcc.doapet.factory;

import com.tcc.doapet.model.dto.request.OrderRequest;
import com.tcc.doapet.model.dto.response.OrderResponse;
import com.tcc.doapet.model.entity.Order;
import com.tcc.doapet.model.enums.OrderStatus;
import com.tcc.doapet.model.enums.PriorityLevelStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OrderFactory {


    public static OrderRequest getOrderWithNoAssistanceOrProductSaveRequest(){
        return OrderRequest.builder()
                .quantity(1)
                .startDateService(LocalDateTime.parse("1986-04-08T12:30:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME))
                .completionDateService(LocalDateTime.parse("1986-04-08T12:30:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME))
                .priorityLevelStatus(PriorityLevelStatus.MEDIUM)
                .build();
    }

    public static OrderRequest getOrderAssistanceSaveRequest(){
        return OrderRequest.builder()
                .assistanceId(1L)
                .quantity(1)
                .startDateService(LocalDateTime.parse("1986-04-08T12:30:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME))
                .completionDateService(LocalDateTime.parse("1986-04-08T12:30:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME))
                .priorityLevelStatus(PriorityLevelStatus.MEDIUM)
                .build();
    }

    public static OrderRequest getOrderAssistanceUpdateRequest(){
        return OrderRequest.builder()
                .assistanceId(1L)
                .quantity(1)
                .orderStatus(OrderStatus.CANCELED)
                .startDateService(LocalDateTime.parse("1986-04-08T12:30:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME))
                .completionDateService(LocalDateTime.parse("1986-04-08T12:30:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME))
                .priorityLevelStatus(PriorityLevelStatus.MEDIUM)
                .build();
    }

    public static OrderResponse getOrderAssistanceResponse() {
        return OrderResponse.builder()
                .id(1L)
                .ong(ONGFactory.getONGResponse())
                .donor(DonorFactory.getDonorResponse())
                .assistance(AssistanceFactory.getAssistanceResponse())
                .orderStatus(OrderStatus.PENDING)
                .date(LocalDate.of(2023, 3, 16))
                .quantity(1)
                .startDateService(LocalDateTime.parse("1986-04-08T12:30:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME))
                .completionDateService(LocalDateTime.parse("1986-04-08T12:30:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME))
                .priorityLevelStatus(PriorityLevelStatus.MEDIUM)
                .build();
    }

    public static Order getAssistanceOrder(){
        return Order.builder()
                .id(1L)
                .ong(ONGFactory.getONG())
                .donor(DonorFactory.getDonor())
                .assistance(AssistanceFactory.getAssistance())
                .orderStatus(OrderStatus.PENDING)
                .date(LocalDate.of(2023, 3, 16))
                .quantity(1)
                .startDateAssistance(LocalDateTime.parse("1986-04-08T12:30:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME))
                .completionDateAssistance(LocalDateTime.parse("1986-04-08T12:30:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME))
                .priorityLevelStatus(PriorityLevelStatus.MEDIUM)
                .build();
    }

    public static OrderRequest getOrderProductSaveRequest(){
       return OrderRequest.builder()
               .productId(1L)
               .quantity(1)
               .startDateService(LocalDateTime.parse("1986-04-08T12:30:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME))
               .completionDateService(LocalDateTime.parse("1986-04-08T12:30:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME))
               .priorityLevelStatus(PriorityLevelStatus.MEDIUM)
               .build();
    }

    public static OrderRequest getOrderProductUpdateRequest(){
        return OrderRequest.builder()
                .productId(1L)
                .quantity(1)
                .orderStatus(OrderStatus.CANCELED)
                .startDateService(LocalDateTime.parse("1986-04-08T12:30:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME))
                .completionDateService(LocalDateTime.parse("1986-04-08T12:30:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME))
                .priorityLevelStatus(PriorityLevelStatus.MEDIUM)
                .build();
    }

    public static OrderResponse getOrderProductResponse() {
        return OrderResponse.builder()
                .id(1L)
                .ong(ONGFactory.getONGResponse())
                .donor(DonorFactory.getDonorResponse())
                .product(ProductFactory.getProductResponse())
                .orderStatus(OrderStatus.PENDING)
                .date(LocalDate.of(2023, 3, 16))
                .quantity(1)
                .startDateService(LocalDateTime.parse("1986-04-08T12:30:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME))
                .completionDateService(LocalDateTime.parse("1986-04-08T12:30:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME))
                .priorityLevelStatus(PriorityLevelStatus.MEDIUM)
                .build();

    }

    public static Order getProductOrder(){
        return Order.builder()
                .id(1L)
                .ong(ONGFactory.getONG())
                .donor(DonorFactory.getDonor())
                .product(ProductFactory.getProduct())
                .orderStatus(OrderStatus.PENDING)
                .date(LocalDate.of(2023, 3, 16))
                .quantity(1)
                .startDateAssistance(LocalDateTime.parse("1986-04-08T12:30:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME))
                .completionDateAssistance(LocalDateTime.parse("1986-04-08T12:30:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME))
                .priorityLevelStatus(PriorityLevelStatus.MEDIUM)
                .build();
    }

}
