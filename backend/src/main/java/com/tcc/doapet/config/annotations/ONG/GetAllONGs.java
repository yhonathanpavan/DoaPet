package com.tcc.doapet.config.annotations.ONG;

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
@Operation(summary = "Lista todos as ONGs, podem ser usados filtros.", description = "Retorna uma página de ONGs",
        tags = {"ONGs"})
@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Ok",
        content = @Content(mediaType = "application/json"))})
public @interface GetAllONGs {
}

