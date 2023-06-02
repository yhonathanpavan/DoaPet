package com.tcc.doapet.service.impl;

import com.tcc.doapet.model.dto.request.OrderStatusUpdate;
import com.tcc.doapet.model.enums.OrderStatus;
import com.tcc.doapet.model.enums.PriorityLevelStatus;
import com.tcc.doapet.repository.AssistanceRepository;
import com.tcc.doapet.repository.ONGRepository;
import com.tcc.doapet.repository.OrderRepository;
import com.tcc.doapet.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.ws.rs.WebApplicationException;
import java.util.List;
import java.util.Optional;

import static com.tcc.doapet.factory.AssistanceFactory.getAssistance;
import static com.tcc.doapet.factory.ONGFactory.getONG;
import static com.tcc.doapet.factory.OrderFactory.*;
import static com.tcc.doapet.factory.ProductFactory.getProduct;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderServiceImplTest {

    @InjectMocks
    private OrderServiceImpl orderService;

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private ONGRepository ongRepository;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private AssistanceRepository assistanceRepository;

    @Spy
    private ModelMapper modelMapper;

    @BeforeEach
    void setUp() {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }


    @Test
    void saveOrderAssistance(){
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        when(orderRepository.save(any())).thenReturn(getAssistanceOrder());
        when(assistanceRepository.findById(anyLong())).thenReturn(Optional.of(getAssistance()));
        when(ongRepository.findById(anyLong())).thenReturn(Optional.of(getONG()));

        var actualOrderResponse = orderService.save(1L, getOrderAssistanceSaveRequest());

        assertNotNull(actualOrderResponse);
        verify(orderRepository, times(1)).save(any());
    }

    @Test
    void saveOrderProduct(){
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        when(orderRepository.save(any())).thenReturn(getProductOrder());
        when(productRepository.findById(anyLong())).thenReturn(Optional.of(getProduct()));
        when(ongRepository.findById(anyLong())).thenReturn(Optional.of(getONG()));

        var actualOrderResponse = orderService.save(1L, getOrderProductSaveRequest());

        assertNotNull(actualOrderResponse);
        verify(orderRepository, times(1)).save(any());
    }

    @Test
    void whenSaveOrderWithNoProductOrAssistanceThrowNotFoundException(){
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        var webApplicationException = new WebApplicationException();
        try {
            orderService.save(1L, getOrderWithNoAssistanceOrProductSaveRequest());
        }catch(WebApplicationException ex){
            webApplicationException = ex;
        }
        assertEquals(HttpStatus.BAD_REQUEST.value(), webApplicationException.getResponse().getStatus());
        assertEquals("Enter product ID or assistance ID", webApplicationException.getMessage());
    }

    @Test
    void findAll() {
        when(orderRepository.findAllByOngId(anyLong(), any(Pageable.class))).thenReturn(new PageImpl<>(List.of(getAssistanceOrder(), getProductOrder())));

        var actualOrderResponse = orderService.findAll(1L, PageRequest.of(0, 10));

        assertNotNull(actualOrderResponse.getContent());
        assertEquals(2, actualOrderResponse.getContent().size());
        assertEquals(getAssistanceOrder().getId(), actualOrderResponse.getContent().get(0).getId());
        assertEquals(getAssistanceOrder().getOng().getId(), actualOrderResponse.getContent().get(0).getOng().getId());
        assertEquals(getAssistanceOrder().getDonor().getId(), actualOrderResponse.getContent().get(0).getDonor().getId());
        assertEquals(getAssistanceOrder().getAssistance().getId(), actualOrderResponse.getContent().get(0).getAssistance().getId());
        assertEquals(getProductOrder().getProduct().getId(), actualOrderResponse.getContent().get(1).getProduct().getId());
        assertEquals(getAssistanceOrder().getOrderStatus(), actualOrderResponse.getContent().get(0).getOrderStatus());
    }

    @Test
    void findOne() {
        when(orderRepository.findByIdAndOngId(anyLong(), anyLong())).thenReturn(Optional.of(getAssistanceOrder()));

        var actualOrderResponse = orderService.findOne(1L, 1L);

        assertNotNull(actualOrderResponse);
        assertEquals(getOrderAssistanceResponse().getId(), actualOrderResponse.getId());
        assertEquals(getOrderAssistanceResponse().getDonor().getCpf(), actualOrderResponse.getDonor().getCpf());
        assertEquals(getOrderAssistanceResponse().getDonor().getName(), actualOrderResponse.getDonor().getName());
        assertEquals(getOrderAssistanceResponse().getOng().getPresidentName(), actualOrderResponse.getOng().getPresidentName());
        assertEquals(getOrderAssistanceResponse().getOng().getCnpj(), actualOrderResponse.getOng().getCnpj());
    }

    @Test
    void getPrioritiesLevelStatus_WhenSendRequest_ExpectedPrioritiesLevelStatus() {
        var response = orderService.getPrioritiesLevelStatus();

        assertNotNull(response);
        assertEquals(PriorityLevelStatus.class, response.get(0).getClass());
    }

    @Test
    void update() {
        when(orderRepository.findByIdAndOngId(anyLong(), anyLong())).thenReturn(Optional.of(getAssistanceOrder()));
        when(orderRepository.save(any())).thenReturn(getAssistanceOrder());

        var actualOrderResponse = orderService.update(1L, 1L, getOrderAssistanceUpdateRequest());

        assertNotNull(actualOrderResponse);
        verify(orderRepository, times(1)).save(any());
    }

    @Test
    void cancelOrder_WhenSendONGIdAndOrderId_ExpectedSuccess() {
        when(orderRepository.findByIdAndOngId(anyLong(), anyLong())).thenReturn(Optional.ofNullable(getAssistanceOrder()));
        when(orderRepository.save(any())).thenReturn(getAssistanceOrder());
        var orderStatusUpdate = new OrderStatusUpdate();
        orderStatusUpdate.setStatus(OrderStatus.FINALIZED);

        var response = orderService.updateOrder(1L, 1L, orderStatusUpdate);

        assertNotNull(response);
        verify(orderRepository, times(1)).save(any());
    }

}