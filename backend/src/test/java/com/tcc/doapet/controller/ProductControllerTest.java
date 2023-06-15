package com.tcc.doapet.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tcc.doapet.factory.ONGFactory;
import com.tcc.doapet.factory.ProductFactory;
import com.tcc.doapet.repository.ProductRepository;
import com.tcc.doapet.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
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

    private final TokenService tokenService;

    private final ObjectMapper objectMapper;

    private String token;

    @BeforeEach
    void setUp(){
        var ong = ONGFactory.getONG();
        Authentication authentication = new UsernamePasswordAuthenticationToken(ong, null);
        token = "Bearer "+tokenService.generateToken(authentication);
        productRepository.save(ProductFactory.getProduct());
    }

    @Test
    public void save_WhenSendProductRequest_ExpectedResponseEntityProductResponse() throws Exception {
        String productRequest = objectMapper.writeValueAsString(ProductFactory.getProductRequest());

        mockMvc.perform(MockMvcRequestBuilders.post("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", token)
                        .content(productRequest))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void findAll_WhenFindAllPageable_ExpectedResponseEntityPageableProductResponse() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/products")
                        .header("Authorization", token)
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(Assertions::assertNotNull)
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void findOne_WhenSendProductId_ExpectedResponseEntityProductResponse() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/products/{id}", 1L)
                .header("Authorization", token)
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(Assertions::assertNotNull)
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void getProductCategories_WhenSendRequest_ExpectedResponseListCategories() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/products/categories")
                .header("Authorization", token)
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(Assertions::assertNotNull)
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void getProductMeasures_WhenSendRequest_ExpectedResponseListMeasures() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/products/measures")
                .header("Authorization", token)
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(Assertions::assertNotNull)
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void update_WhenSendProductRequest_ExpectedResponseEntityProductResponse() throws Exception {
        String productRequest = objectMapper.writeValueAsString(ProductFactory.getProductRequest());
        mockMvc.perform(MockMvcRequestBuilders.patch("/products/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", token)
                        .content(productRequest))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void updateStatus_WhenSendProductId_ExpectedResponseEntityProductResponse() throws Exception {
        String productRequest = objectMapper.writeValueAsString(ProductFactory.getProductRequest());
        mockMvc.perform(MockMvcRequestBuilders.patch("/products/{id}/status", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", token)
                        .content(productRequest))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
}