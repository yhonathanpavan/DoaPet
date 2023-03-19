package com.tcc.doapet.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tcc.doapet.model.enums.AssistanceCategory;
import com.tcc.doapet.model.enums.PriorityLevelStatus;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Assistance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(value = EnumType.STRING)
    @JsonProperty("assistance_category")
    private AssistanceCategory assistanceCategory;

    @Enumerated(value = EnumType.STRING)
    @JsonProperty("priority_level_status")
    private PriorityLevelStatus priorityLevelStatus;

    private boolean active;
}
