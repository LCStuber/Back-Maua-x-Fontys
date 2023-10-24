package com.fontysxmaua.UniGuide.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ActivityResponse {
    private final String id;
    private final String name;
    private final String room;
    private final Date time;
}
