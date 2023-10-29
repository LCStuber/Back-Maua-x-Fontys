package com.fontysxmaua.UniGuide.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ActivityResponse {
    private final String id;
    private Boolean isMandatory;
    private Date startDate;
    private Date endDate;
    private final String name;
    private String description;
    private final String room;
    private Integer capacity;
}
