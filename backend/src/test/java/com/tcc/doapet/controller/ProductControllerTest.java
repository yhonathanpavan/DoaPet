package com.tcc.doapet.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tcc.doapet.factory.ProductFactory;
import com.tcc.doapet.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc()
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
class ProductControllerTest {

    private final MockMvc mockMvc;

    private final ProductRepository productRepository;

    private final ObjectMapper objectMapper;

    @BeforeEach
    void setUp(){
        productRepository.save(ProductFactory.getProduct());
    }

    @Test
    public void save_WhenSendProductRequest_ExpectedResponseEntityProductResponse() throws Exception {
        String productRequest = objectMapper.writeValueAsString(ProductFactory.getProductRequest());

        mockMvc.perform(MockMvcRequestBuilders.post("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(productRequest))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void findAll_WhenFindAllPageable_ExpectedResponseEntityPageableProductResponse() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/products"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(Assertions::assertNotNull)
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void findOne_WhenSendProductId_ExpectedResponseEntityProductResponse() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/products/{id}", 1L))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(Assertions::assertNotNull)
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void update_WhenSendProductRequest_ExpectedResponseEntityProductResponse() throws Exception {
        String productRequest = objectMapper.writeValueAsString(ProductFactory.getProductRequest());
        mockMvc.perform(MockMvcRequestBuilders.patch("/products/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(productRequest))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

}