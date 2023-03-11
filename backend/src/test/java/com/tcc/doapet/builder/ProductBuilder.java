package com.tcc.doapet.builder;

import com.tcc.doapet.model.dto.request.ProductRequest;
import com.tcc.doapet.model.dto.response.ProductResponse;
import com.tcc.doapet.model.entity.Product;
import com.tcc.doapet.model.enums.PriorityLevelStatus;
import com.tcc.doapet.model.enums.ProductCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;

public class ProductBuilder {

    private static final Long ID = 1L;

    private static String NAME = "Pá";

    private static String UNIT = "unitário";

    private static Double WEIGHT = 2.5;

    private static PriorityLevelStatus PRIORITY_LEVEL_STATUS = PriorityLevelStatus.MEDIUM;


    private static ProductCategory PRODUCT_CATEGORY = ProductCategory.TOOL;

    private static Boolean ACTIVE = Boolean.TRUE;

    public static Product getProduct(){
        return Product.builder()
                .id(ID)
                .name(NAME)
                .unit(UNIT)
                .weight(WEIGHT)
                .priorityLevelStatus(PRIORITY_LEVEL_STATUS)
                .productCategory(PRODUCT_CATEGORY)
                .active(ACTIVE)
                .build();
    }

    public static ProductRequest getProductRequest(){
        return ProductRequest.builder()
                .name(NAME)
                .unit(UNIT)
                .weight(WEIGHT)
                .priorityLevelStatus(PRIORITY_LEVEL_STATUS)
                .productCategory(PRODUCT_CATEGORY)
                .build();
    }

    public static ProductResponse getProductResponse(){
        return ProductResponse.builder()
                .name(NAME)
                .unit(UNIT)
                .weight(WEIGHT)
                .priorityLevelStatus(PRIORITY_LEVEL_STATUS)
                .productCategory(PRODUCT_CATEGORY)
                .active(ACTIVE)
                .build();
    }

    public static Page<Product> getProductPageable(){
        return new PageImpl<>(List.of(ProductBuilder.getProduct()));
    }

    public static Page<ProductResponse> getProductResponsePageable(){
        return new PageImpl<>(List.of(ProductBuilder.getProductResponse()));
    }
}
