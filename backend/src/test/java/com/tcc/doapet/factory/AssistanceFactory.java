package com.tcc.doapet.factory;

import com.tcc.doapet.model.dto.request.AssistanceRequest;
import com.tcc.doapet.model.dto.response.AssistanceResponse;
import com.tcc.doapet.model.entity.Assistance;
import com.tcc.doapet.model.enums.AssistanceCategory;
import com.tcc.doapet.model.enums.PriorityLevelStatus;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;

public class AssistanceFactory {

    @Autowired
    private static ModelMapper modelMapper;

    public static Assistance getAssistance(){
        return Assistance.builder()
                .id(1L)
                .name("Castration of Dogs and Cats")
                .assistanceCategory(AssistanceCategory.HEALTH)
                .priorityLevelStatus(PriorityLevelStatus.HIGH)
                .active(true)
                .build();
    }

    public static Assistance getAssistanceTwo(){
        return Assistance.builder()
                .id(2L)
                .name("Vaccination")
                .assistanceCategory(AssistanceCategory.HEALTH)
                .priorityLevelStatus(PriorityLevelStatus.MEDIUM)
                .active(true)
                .build();
    }


    public static AssistanceResponse getAssistanceResponse(){
        return AssistanceResponse.builder()
                .id(1L)
                .name("Castration of Dogs and Cats")
                .assistanceCategory(AssistanceCategory.HEALTH)
                .priorityLevelStatus(PriorityLevelStatus.HIGH)
                .active(true)
                .build();
    }

    public static AssistanceResponse getAssistanceResponseTwo(){
        return AssistanceResponse.builder()
                .id(2L)
                .name("Vaccination")
                .assistanceCategory(AssistanceCategory.HEALTH)
                .priorityLevelStatus(PriorityLevelStatus.MEDIUM)
                .active(true)
                .build();
    }

    public static AssistanceRequest getAssistanceRequest(){
        return AssistanceRequest.builder()
                .name("Castration of Dogs and Cats")
                .assistanceCategory(AssistanceCategory.HEALTH)
                .priorityLevelStatus(PriorityLevelStatus.HIGH)
                .active(true)
                .build();
    }

    public static List<AssistanceResponse> getAssistanceResponseArray(){
        return List.of(getAssistanceResponse(), getAssistanceResponseTwo());
    }

    public static List<Assistance> getAssistanceArray(){
        return List.of(getAssistance(), getAssistanceTwo());

    }

    public static Page<AssistanceResponse> getPageableAssistanceResponse(){
        return new PageImpl<>(getAssistanceResponseArray());
    }

}
