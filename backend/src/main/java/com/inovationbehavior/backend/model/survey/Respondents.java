package com.inovationbehavior.backend.model.survey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Respondents {
    private String patentNo;
    private String gender;
    private String major;
    private String degree;
    private String role;
    private String income;
    private String experience;
}
