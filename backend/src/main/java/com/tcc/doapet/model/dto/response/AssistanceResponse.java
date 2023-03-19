package com.tcc.doapet.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tcc.doapet.model.enums.AssistanceCategory;
import com.tcc.doapet.model.enums.PriorityLevelStatus;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AssistanceResponse {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("assistance_category")
    private AssistanceCategory assistanceCategory;

    @JsonProperty("priority_level_status")
    private PriorityLevelStatus priorityLevelStatus;

    @JsonProperty("active")
    private boolean active;

}
