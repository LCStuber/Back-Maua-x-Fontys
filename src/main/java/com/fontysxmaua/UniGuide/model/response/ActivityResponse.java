package com.fontysxmaua.UniGuide.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
public class ActivityResponse {
    private final String id;
    private final Boolean isMandatory;
    private final Date startDate;
    private final Date endDate;
    private final String name;
    private final String description;
    private final String room;
    private final Integer capacity;
    private final Set<String> subscribed;
    private final Set<String> attending;
    private final String lector;
}
