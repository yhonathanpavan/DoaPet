package com.tcc.doapet.config.annotations.Products;

import com.tcc.doapet.exception.handler.ApiExceptionHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Operation(summary = "Atualiza um produto existente.", description = "Atualiza os dados de produto já existente",
        tags = {"Produtos"})
@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Ok", content = @Content(mediaType = "application/json")),
        @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(array = @ArraySchema(schema = @Schema(implementation = ApiExceptionHandler.class)), mediaType = "application/json")),
        @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(implementation = ApiExceptionHandler.class), mediaType = "application/json"))} )
public @interface PatchProduct {
}

