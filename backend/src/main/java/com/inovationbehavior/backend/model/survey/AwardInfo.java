package com.inovationbehavior.backend.model.survey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AwardInfo {
    private String patentNo;
    private Integer award;
    private String address;
}
