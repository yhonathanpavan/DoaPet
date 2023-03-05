package com.tcc.doapet.builder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tcc.doapet.model.dto.request.ONGRequest;
import com.tcc.doapet.model.dto.response.ONGResponse;
import com.tcc.doapet.model.entity.ONG;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.Arrays;

public class ONGBuilder {


    public static ONG getONG() throws JsonProcessingException {
        return new ObjectMapper().readValue("{\n" +
                "    \"id\": 1,\n" +
                "    \"name\":\"ONG Patinhas unidas\",\n" +
                "    \"email\":\"patinhasunidas@email.com\",\n" +
                "    \"password\":\"123\",\n" +
                "    \"phone_number\":\"15984985768\",\n" +
                "    \"street\":\"Rua Célia Asse Jacob\",\n" +
                "    \"number\":\"669\",\n" +
                "    \"neighborhood\":\"Jardim Imperial\",\n" +
                "    \"city\":\"Sorocaba\",\n" +
                "    \"state\":\"SP\",\n" +
                "    \"cnpj\":\"04912441000110\",\n" +
                "    \"pix\":\"patinhasunidas@email.com\",\n" +
                "    \"president_name\":\"Cláudia Carolina Sara da Luz\",\n" +
                "    \"biography\":\"A ONG Patinhas unidas foi fundada em 2014 com o propósito de dar uma nova vida para os animais de rua\",\n" +
                "    \"active\":true\n" +
                "}", ONG.class);
    }

    public static ONGResponse getONGResponse() throws JsonProcessingException {
        return new ObjectMapper().readValue("{\n" +
                "    \"id\": 1,\n" +
                "    \"name\":\"ONG Patinhas unidas\",\n" +
                "    \"email\":\"patinhasunidas@email.com\",\n" +
                "    \"phone_number\":\"15984985768\",\n" +
                "    \"street\":\"Rua Célia Asse Jacob\",\n" +
                "    \"number\":\"669\",\n" +
                "    \"neighborhood\":\"Jardim Imperial\",\n" +
                "    \"city\":\"Sorocaba\",\n" +
                "    \"state\":\"SP\",\n" +
                "    \"cnpj\":\"04912441000110\",\n" +
                "    \"pix\":\"patinhasunidas@email.com\",\n" +
                "    \"president_name\":\"Cláudia Carolina Sara da Luz\",\n" +
                "    \"biography\":\"A ONG Patinhas unidas foi fundada em 2014 com o propósito de dar uma nova vida para os animais de rua\",\n" +
                "    \"active\":true\n" +
                "}", ONGResponse.class);
    }

    public static ONGRequest getONGRequest() throws JsonProcessingException {
        return new ObjectMapper().readValue("{\n" +
                "    \"name\":\"ONG Patinhas unidas\",\n" +
                "    \"email\":\"patinhasunidas@email.com\",\n" +
                "    \"password\":\"123\",\n" +
                "    \"phone_number\":\"15984985768\",\n" +
                "    \"street\":\"Rua Célia Asse Jacob\",\n" +
                "    \"number\":\"669\",\n" +
                "    \"neighborhood\":\"Jardim Imperial\",\n" +
                "    \"city\":\"Sorocaba\",\n" +
                "    \"state\":\"SP\",\n" +
                "    \"cnpj\":\"04912441000110\",\n" +
                "    \"pix\":\"patinhasunidas@email.com\",\n" +
                "    \"president_name\":\"Cláudia Carolina Sara da Luz\",\n" +
                "    \"biography\":\"A ONG Patinhas unidas foi fundada em 2014 com o propósito de dar uma nova vida para os animais de rua\",\n" +
                "    \"active\":true\n" +
                "}", ONGRequest.class);
    }

    public static ONGResponse[] getONGResponseArray() throws JsonProcessingException {
        return new ObjectMapper().readValue(
         "[\n" +
                 "        {\n" +
                 "            \"id\": 1,\n" +
                 "            \"name\": \"ONG Patinhas unidas\",\n" +
                 "            \"email\": \"patinhasunidas@email.com\",\n" +
                 "            \"phone_number\": \"15984985768\",\n" +
                 "            \"street\": \"Rua Célia Asse Jacob\",\n" +
                 "            \"number\": \"669\",\n" +
                 "            \"neighborhood\": \"Jardim Imperial\",\n" +
                 "            \"city\": \"Sorocaba\",\n" +
                 "            \"state\": \"SP\",\n" +
                 "            \"cnpj\": \"04912441000110\",\n" +
                 "            \"pix\": \"patinhasunidas@email.com\",\n" +
                 "            \"president_name\": \"Cláudia Carolina Sara da Luz\",\n" +
                 "            \"biography\": \"A ONG Patinhas unidas foi fundada em 2014 com o propósito de dar uma nova vida para os animais de rua\",\n" +
                 "            \"active\": true\n" +
                 "        },\n" +
                 "        {\n" +
                 "            \"id\": 2,\n" +
                 "            \"name\": \"ONG Focinhos Carinhosos\",\n" +
                 "            \"email\": \"focinhoscarinhosos@email.com\",\n" +
                 "            \"phone_number\": \"11982746982\",\n" +
                 "            \"street\": \"Alameda Piratuba\",\n" +
                 "            \"number\": \"198\",\n" +
                 "            \"neighborhood\": \"Residencial Morada dos Lagos\",\n" +
                 "            \"city\": \"Barueri\",\n" +
                 "            \"state\": \"SP\",\n" +
                 "            \"cnpj\": \"91310562000197\",\n" +
                 "            \"pix\": \"focinhoscarinhosos@email.com\",\n" +
                 "            \"president_name\": \"Benedito Vicente Ribeiro\",\n" +
                 "            \"biography\": \"A Focinhos Carinhosos atua na cidade de Barueri desde 2007, prestando serviços e ajudando os animaizinhos necessitados.\",\n" +
                 "            \"active\": true\n" +
                 "        }\n" +
                 "    ]", ONGResponse[].class);
    }

    public static ONG[] getONGArray() throws JsonProcessingException {
        return new ObjectMapper().readValue(
                 "[\n" +
                         "        {\n" +
                         "            \"id\": 1,\n" +
                         "            \"name\": \"ONG Patinhas unidas\",\n" +
                         "            \"email\": \"patinhasunidas@email.com\",\n" +
                         "            \"password\":\"123\",\n" +
                         "            \"phone_number\": \"15984985768\",\n" +
                         "            \"street\": \"Rua Célia Asse Jacob\",\n" +
                         "            \"number\": \"669\",\n" +
                         "            \"neighborhood\": \"Jardim Imperial\",\n" +
                         "            \"city\": \"Sorocaba\",\n" +
                         "            \"state\": \"SP\",\n" +
                         "            \"cnpj\": \"04912441000110\",\n" +
                         "            \"pix\": \"patinhasunidas@email.com\",\n" +
                         "            \"president_name\": \"Cláudia Carolina Sara da Luz\",\n" +
                         "            \"biography\": \"A ONG Patinhas unidas foi fundada em 2014 com o propósito de dar uma nova vida para os animais de rua\",\n" +
                         "            \"active\": true\n" +
                         "        },\n" +
                         "        {\n" +
                         "            \"id\": 2,\n" +
                         "            \"name\": \"ONG Focinhos Carinhosos\",\n" +
                         "            \"email\": \"focinhoscarinhosos@email.com\",\n" +
                         "            \"password\":\"123\",\n" +
                         "            \"phone_number\": \"11982746982\",\n" +
                         "            \"street\": \"Alameda Piratuba\",\n" +
                         "            \"number\": \"198\",\n" +
                         "            \"neighborhood\": \"Residencial Morada dos Lagos\",\n" +
                         "            \"city\": \"Barueri\",\n" +
                         "            \"state\": \"SP\",\n" +
                         "            \"cnpj\": \"91310562000197\",\n" +
                         "            \"pix\": \"focinhoscarinhosos@email.com\",\n" +
                         "            \"president_name\": \"Benedito Vicente Ribeiro\",\n" +
                         "            \"biography\": \"A Focinhos Carinhosos atua na cidade de Barueri desde 2007, prestando serviços e ajudando os animaizinhos necessitados.\",\n" +
                         "            \"active\": true\n" +
                         "        }\n" +
                         "    ]", ONG[].class);
    }

    public static Page<ONGResponse> getPageableONGResponse() throws JsonProcessingException {
        return new PageImpl<>(Arrays.stream(getONGResponseArray()).toList());
    }

}
