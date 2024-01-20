package com.inovationbehavior.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patent {
    String no;
    String name;
    String summary;
    String link;
    Timestamp update_time;
}
