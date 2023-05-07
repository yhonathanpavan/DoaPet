package com.tcc.doapet.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class ApiExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> notFoundExceptionHandler(NotFoundException ex){
        var responseCreated = createResponse("NOT_FOUND", "The requested resource is not found");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseCreated);
    }

    @ExceptionHandler(ClientErrorException.class)
    public ResponseEntity<Object> clientErrorExceptionHandler(NotFoundException ex){
        var responseCreated = createResponse("CONFLICT", ex.getMessage() + " Already registered");
        return ResponseEntity.status(HttpStatus.CONFLICT).body(responseCreated);
    }

    @ExceptionHandler(NotAuthorizedException.class)
    public ResponseEntity<Object> notAuthorizedExceptionHandler(NotAuthorizedException ex){
        var responseCreated = createResponse("UNAUTHORIZED", "Not authorized");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseCreated);
    }

    @ExceptionHandler(MissingRequestHeaderException.class)
    public ResponseEntity<Object> missingRequestHeaderExceptionHandler(NotAuthorizedException ex){
        var responseCreated = createResponse("BAD_REQUEST", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseCreated);
    }

    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<Object> forbiddenExceptionHandler(ForbiddenException ex){
        var responseCreated = createResponse("FORBIDDEN", ex.getMessage());
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(responseCreated);
    }

    @ExceptionHandler(JdbcSQLIntegrityConstraintViolationException.class)
    public ResponseEntity<Object> jdbcConstraintViolationHandler(JdbcSQLIntegrityConstraintViolationException ex){
        var responseCreated = createResponse("CONFLICT", ex.getMessage().split("'")[1]+" Already registered");
        return ResponseEntity.status(HttpStatus.CONFLICT).body(responseCreated);
    }


    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Object> notBadRequestExceptionHandler(BadRequestException ex){
        var responseCreated = createResponse("BAD_REQUEST", "The request contains invalid data");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseCreated);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> badRequestExceptionHandler(MethodArgumentNotValidException ex){

        List<Map<String, String>> errors = new ArrayList<>();
        for(FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            String exMessage = fieldError.getField() + " " + fieldError.getDefaultMessage();
            var responseCreated = createResponse("BAD_REQUEST", exMessage);
            errors.add(responseCreated);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }


    public static Map<String, String> createResponse(String code, String message){
        log.error("An Exception Ocurred | Code: {} | Message: {}", code, message);

        Map<String, String> response = new HashMap<>();
        response.put("code", code);
        response.put("message", message);
        return response;
    }


}
