package com.tcc.doapet.builder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.tcc.doapet.model.dto.request.DonorRequest;
import com.tcc.doapet.model.dto.response.DonorResponse;
import com.tcc.doapet.model.entity.Donor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.Arrays;

public class DonorBuilder {

    public static Donor getDonor() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper.readValue("{\n" +
                "    \"id\": 1,\n" +
                "    \"name\":\"Davi Filipe Oliver Oliveira\",\n" +
                "    \"email\":\"davifilipeoliveira@kuehne-nagel.com\",\n" +
                "    \"password\":\"123\",\n" +
                "    \"phone_number\":\"12982613354\",\n" +
                "    \"street\":\"Rua José Ferreira\",\n" +
                "    \"number\":\"406\",\n" +
                "    \"neighborhood\":\"Tinga\",\n" +
                "    \"city\":\"Caraguatatuba\",\n" +
                "    \"state\":\"SP\",\n" +
                "    \"cpf\":\"84545610803\",\n" +
                "    \"birthdate\":\"2003-03-05\",\n" +
                "    \"active\":true\n" +
                "}", Donor.class);
    }

    public static DonorResponse getDonorResponse() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper.readValue("{\n" +
                "    \"id\": 1,\n" +
                "    \"name\":\"Davi Filipe Oliver Oliveira\",\n" +
                "    \"email\":\"davifilipeoliveira@kuehne-nagel.com\",\n" +
                "    \"phone_number\":\"12982613354\",\n" +
                "    \"street\":\"Rua José Ferreira\",\n" +
                "    \"number\":\"406\",\n" +
                "    \"neighborhood\":\"Tinga\",\n" +
                "    \"city\":\"Caraguatatuba\",\n" +
                "    \"state\":\"SP\",\n" +
                "    \"cpf\":\"84545610803\",\n" +
                "    \"birthdate\":\"2003-03-05\",\n" +
                "    \"active\":true\n" +
                "}", DonorResponse.class);
    }

    public static DonorRequest getDonorRequest() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper.readValue("{\n" +
                "    \"name\":\"Davi Filipe Oliver Oliveira\",\n" +
                "    \"email\":\"davifilipeoliveira@kuehne-nagel.com\",\n" +
                "    \"password\":\"123\",\n" +
                "    \"phone_number\":\"12982613354\",\n" +
                "    \"street\":\"Rua José Ferreira\",\n" +
                "    \"number\":\"406\",\n" +
                "    \"neighborhood\":\"Tinga\",\n" +
                "    \"city\":\"Caraguatatuba\",\n" +
                "    \"state\":\"SP\",\n" +
                "    \"cpf\":\"84545610803\",\n" +
                "    \"birthdate\":\"2003-03-05\",\n" +
                "    \"active\":true\n" +
                "}", DonorRequest.class);
    }

    public static DonorResponse[] getDonorResponseArray() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper.readValue(
         "[\n" +
                 "        {\n" +
                 "            \"id\": 1,\n" +
                 "            \"name\": \"Davi Filipe Oliver Oliveira\",\n" +
                 "            \"email\": \"davifilipeoliveira@kuehne-nagel.com\",\n" +
                 "            \"phone_number\": \"12982613354\",\n" +
                 "            \"street\": \"Rua José Ferreira\",\n" +
                 "            \"number\": \"406\",\n" +
                 "            \"neighborhood\": \"Tinga\",\n" +
                 "            \"city\": \"Caraguatatuba\",\n" +
                 "            \"state\": \"SP\",\n" +
                 "            \"cpf\": \"84545610803\",\n" +
                 "            \"birthdate\": \"2003-03-05\",\n" +
                 "            \"active\": true\n" +
                 "        },\n" +
                 "        {\n" +
                 "            \"id\": 2,\n" +
                 "            \"name\": \"Eduardo Pedro Henrique Luiz Ramos\",\n" +
                 "            \"email\": \"eduardo.pedro.ramos@multmed.com.br\",\n" +
                 "            \"phone_number\": \"11999693910\",\n" +
                 "            \"street\": \"Via de Pedestre Sonho de Verão\",\n" +
                 "            \"number\": \"339\",\n" +
                 "            \"neighborhood\": \"Parque Guaianazes\",\n" +
                 "            \"city\": \"São Paulo\",\n" +
                 "            \"state\": \"SP\",\n" +
                 "            \"cpf\": \"92188673859\",\n" +
                 "            \"birthdate\": \"2003-03-01\",\n" +
                 "            \"active\": true\n" +
                 "        }\n" +
                 "    ]", DonorResponse[].class);
    }

    public static Donor[] getDonorArray() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper.readValue(
                "[\n" +
                        "        {\n" +
                        "            \"id\": 1,\n" +
                        "            \"name\": \"Davi Filipe Oliver Oliveira\",\n" +
                        "            \"email\": \"davifilipeoliveira@kuehne-nagel.com\",\n" +
                        "            \"password\":\"123\",\n" +
                        "            \"phone_number\": \"12982613354\",\n" +
                        "            \"street\": \"Rua José Ferreira\",\n" +
                        "            \"number\": \"406\",\n" +
                        "            \"neighborhood\": \"Tinga\",\n" +
                        "            \"city\": \"Caraguatatuba\",\n" +
                        "            \"state\": \"SP\",\n" +
                        "            \"cpf\": \"84545610803\",\n" +
                        "            \"birthdate\": \"2003-03-05\",\n" +
                        "            \"active\": true\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"id\": 2,\n" +
                        "            \"name\": \"Eduardo Pedro Henrique Luiz Ramos\",\n" +
                        "            \"email\": \"eduardo.pedro.ramos@multmed.com.br\",\n" +
                        "            \"password\":\"123\",\n" +
                        "            \"phone_number\": \"11999693910\",\n" +
                        "            \"street\": \"Via de Pedestre Sonho de Verão\",\n" +
                        "            \"number\": \"339\",\n" +
                        "            \"neighborhood\": \"Parque Guaianazes\",\n" +
                        "            \"city\": \"São Paulo\",\n" +
                        "            \"state\": \"SP\",\n" +
                        "            \"cpf\": \"92188673859\",\n" +
                        "            \"birthdate\": \"2003-03-01\",\n" +
                        "            \"active\": true\n" +
                        "        }\n" +
                        "    ]", Donor[].class);
    }

    public static Page<DonorResponse> getPageableDonorResponse() throws JsonProcessingException {
        return new PageImpl<>(Arrays.stream(getDonorResponseArray()).toList());
    }

}
