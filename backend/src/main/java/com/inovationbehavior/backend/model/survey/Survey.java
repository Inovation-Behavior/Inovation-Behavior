package com.inovationbehavior.backend.model.survey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Survey {
    private String patentNo;
    private String identification;
    private String evaluate;
    private String value;
}
