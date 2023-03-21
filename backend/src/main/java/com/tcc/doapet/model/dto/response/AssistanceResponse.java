package com.tcc.doapet.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tcc.doapet.model.enums.AssistanceCategory;
import lombok.*;

import java.math.BigDecimal;

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

    @JsonProperty("price")
    private BigDecimal price;

    @JsonProperty("status")
    private Boolean status;

}
