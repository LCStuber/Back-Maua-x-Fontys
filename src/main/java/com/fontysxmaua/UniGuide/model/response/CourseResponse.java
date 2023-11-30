package com.fontysxmaua.UniGuide.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CourseResponse {
    private final String id;
    private final String name;
    private final String coordinator;
    private final String coordinatorImage;
    private final String coordinatorEmail;
    private final String url;
    private final String description;
}
