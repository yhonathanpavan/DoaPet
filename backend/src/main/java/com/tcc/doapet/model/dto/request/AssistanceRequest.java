package com.tcc.doapet.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tcc.doapet.model.enums.AssistanceCategory;
import com.tcc.doapet.model.enums.PriorityLevelStatus;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AssistanceRequest {

    @NotBlank
    @JsonProperty("name")
    private String name;

    @NotNull
    @JsonProperty("assistance_category")
    private AssistanceCategory assistanceCategory;

    @NotNull
    @JsonProperty("priority_level_status")
    private PriorityLevelStatus priorityLevelStatus;

    @JsonProperty("active")
    private Boolean active;
}
