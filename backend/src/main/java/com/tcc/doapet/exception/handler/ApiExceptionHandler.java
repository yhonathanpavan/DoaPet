package com.tcc.doapet.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.ws.rs.NotFoundException;
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


    public Map<String, String> createResponse(String code, String message){
        log.warn("An Exception Ocurred | Code: {} | Message: {}", code, message);

        Map<String, String> response = new HashMap<>();
        response.put("code", code);
        response.put("message", message);
        return response;
    }


}
