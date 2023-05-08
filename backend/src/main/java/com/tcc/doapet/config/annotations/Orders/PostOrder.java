package com.tcc.doapet.config.annotations.Orders;

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
@Operation(summary = "Cria um novo pedido.", description = "Persiste um novo pedido no banco de dados",
        tags = {"Pedidos"})
@ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Created", content = @Content(mediaType = "application/json")),
        @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(array = @ArraySchema(schema = @Schema(implementation = ApiExceptionHandler.class)), mediaType = "application/json"))} )
public @interface PostOrder {
}

