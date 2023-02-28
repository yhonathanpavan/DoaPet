package com.tcc.doapet.builder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tcc.doapet.model.dto.request.AssistanceRequest;
import com.tcc.doapet.model.dto.response.AssistanceResponse;
import com.tcc.doapet.model.entity.Assistance;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.Arrays;

public class AssistanceBuilder {

    @Autowired
    private static ModelMapper modelMapper;

    public static Assistance getAssistance() throws JsonProcessingException {
        return new ObjectMapper().readValue("{\n" +
                "    \"id\": 1,\n" +
                "    \"name\":\"Castration of Dogs and Cats\",\n" +
                "    \"assistance_category\": \"health\",\n" +
                "    \"priority_level_status\": \"high\",\n" +
                "    \"active\":true\n" +
                "}", Assistance.class);
    }

    public static AssistanceResponse getAssistanceResponse() throws JsonProcessingException {
        return new ObjectMapper().readValue("{\n" +
                "    \"id\": 1,\n" +
                "    \"name\":\"Castration of Dogs and Cats\",\n" +
                "    \"assistance_category\": \"health\",\n" +
                "    \"priority_level_status\": \"high\",\n" +
                "    \"active\":true\n" +
                "}", AssistanceResponse.class);
    }

    public static AssistanceRequest getAssistanceRequest() throws JsonProcessingException {
        return new ObjectMapper().readValue("{\n" +
                "    \"name\":\"Castration of Dogs and Cats\",\n" +
                "    \"assistance_category\": \"health\",\n" +
                "    \"priority_level_status\": \"high\",\n" +
                "    \"active\":true\n" +
                "}", AssistanceRequest.class);
    }

    public static AssistanceResponse[] getAssistanceResponseArray() throws JsonProcessingException {
        return new ObjectMapper().readValue(
         "    [ \n" +
                "        {\n" +
                "            \"id\": 1,\n" +
                "            \"name\": \"Castration of Dogs and Cats\",\n" +
                "            \"assistance_category\": \"HEALTH\",\n" +
                "            \"priority_level_status\": \"HIGH\",\n" +
                "            \"active\": true\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 2,\n" +
                "            \"name\": \"Vaccination\",\n" +
                "            \"assistance_category\": \"HEALTH\",\n" +
                "            \"priority_level_status\": \"MEDIUM\",\n" +
                "            \"active\": true\n" +
                "        }\n" +
                "    ] \n", AssistanceResponse[].class);
    }

    public static Assistance[] getAssistanceArray() throws JsonProcessingException {
        return new ObjectMapper().readValue(
                "    [ \n" +
                        "        {\n" +
                        "            \"id\": 1,\n" +
                        "            \"name\": \"Castration of Dogs and Cats\",\n" +
                        "            \"assistance_category\": \"HEALTH\",\n" +
                        "            \"priority_level_status\": \"HIGH\",\n" +
                        "            \"active\": true\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"id\": 2,\n" +
                        "            \"name\": \"Vaccination\",\n" +
                        "            \"assistance_category\": \"HEALTH\",\n" +
                        "            \"priority_level_status\": \"MEDIUM\",\n" +
                        "            \"active\": true\n" +
                        "        }\n" +
                        "    ] \n", Assistance[].class);
    }

    public static Page<AssistanceResponse> getPageableAssistanceResponse() throws JsonProcessingException {
        return new PageImpl<>(Arrays.stream(getAssistanceResponseArray()).toList());
    }

}
