package com.fontysxmaua.UniGuide.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CourseResponse {
    private final String id;
    private final String name;
    private final String description;
    private final String coordinator;
}
