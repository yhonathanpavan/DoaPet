package com.tcc.doapet.config.annotations.Donors;

import com.tcc.doapet.exception.handler.ApiExceptionHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@SecurityRequirement(name = "bearerAuth")
@Operation(summary = "Atualiza um doador existente.", description = "Atualiza os dados de um doador já existente",
        tags = {"Doadores"})
@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Ok", content = @Content(mediaType = "application/json")),
        @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(array = @ArraySchema(schema = @Schema(implementation = ApiExceptionHandler.class)), mediaType = "application/json")),
        @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(implementation = ApiExceptionHandler.class), mediaType = "application/json"))} )
public @interface PatchDonor {
}

