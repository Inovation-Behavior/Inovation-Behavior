package com.inovationbehavior.backend.model.survey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatentStrategy {
    private String patentNo;
    private String financialValue;
    private String holdReason;
    private String importance;
    private String commercializeMethods;
    private String isSuccessful;
    private String obstaclesExtent;
    private String facilitateOptions;
    private String publicSupport;
}
