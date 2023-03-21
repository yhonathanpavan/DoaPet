package com.tcc.doapet.factory;

import com.tcc.doapet.model.dto.request.ProductRequest;
import com.tcc.doapet.model.dto.response.ProductResponse;
import com.tcc.doapet.model.entity.Product;
import com.tcc.doapet.model.enums.Measures;
import com.tcc.doapet.model.enums.ProductCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.math.BigDecimal;
import java.util.List;

public class ProductFactory {

    private static final Long ID = 1L;

    private static final String NAME = "Pá";

    private static final Measures MEASURE = Measures.UNITS;

    private static final ProductCategory PRODUCT_CATEGORY = ProductCategory.TOOL;

    private static final BigDecimal PRICE = BigDecimal.valueOf(50);

    private static final Boolean ACTIVE = Boolean.TRUE;

    public static Product getProduct(){
        return Product.builder()
                .id(ID)
                .name(NAME)
                .measure(MEASURE)
                .productCategory(PRODUCT_CATEGORY)
                .price(PRICE)
                .status(ACTIVE)
                .build();
    }

    public static ProductRequest getProductRequest(){
        return ProductRequest.builder()
                .name(NAME)
                .measure(MEASURE)
                .productCategory(PRODUCT_CATEGORY)
                .price(PRICE)
                .build();
    }

    public static ProductResponse getProductResponse(){
        return ProductResponse.builder()
                .name(NAME)
                .measure(MEASURE)
                .productCategory(PRODUCT_CATEGORY)
                .price(PRICE)
                .status(ACTIVE)
                .build();
    }

    public static Page<Product> getProductPageable(){
        return new PageImpl<>(List.of(ProductFactory.getProduct()));
    }

    public static Page<ProductResponse> getProductResponsePageable(){
        return new PageImpl<>(List.of(ProductFactory.getProductResponse()));
    }
}
