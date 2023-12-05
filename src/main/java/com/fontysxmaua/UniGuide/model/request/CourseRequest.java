package com.fontysxmaua.UniGuide.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequest {
    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Coordinator's name is required")
    private String coordinator;

    @NotBlank(message = "Coordinator's Image is required")
    private String coordinatorLink;

    @NotBlank(message = "Coordinator's Email is required")
    private String coordinatorEmail;

    @NotBlank(message = "Image URL is required")
    private String url;

    private String description;

    @NotBlank(message = "Display Image is required")
    private String displayImage;
}
