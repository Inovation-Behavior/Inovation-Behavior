package com.inovationbehavior.backend.model.survey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessActivity {
    private String patentNo;
    private String stage;
    private String charac;
    private String users;
    private String sector;
    private String inventor;
    private String revenue;
    private String continueDevelop;
    private String importance;
    private String marketConditions;
    private String patent;
    private String majorHurdles;
}
