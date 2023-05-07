package com.tcc.doapet.config.annotations.Products;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Operation(summary = "Lista as categorias.", description = "Retorna lista com todos as categorias de produtos",
        tags = {"Produtos"})
@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Ok",
        content = @Content(mediaType = "application/json"))})
public @interface GetProductCategories {
}

