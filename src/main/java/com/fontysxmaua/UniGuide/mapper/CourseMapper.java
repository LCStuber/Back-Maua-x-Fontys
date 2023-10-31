package com.fontysxmaua.UniGuide.mapper;

import com.fontysxmaua.UniGuide.model.entity.Course;
import com.fontysxmaua.UniGuide.model.request.CourseRequest;
import com.fontysxmaua.UniGuide.model.response.CourseResponse;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {
    public CourseResponse toResponse(Course course) {
        return new CourseResponse(
                course.getId(),
                course.getName(),
                course.getDescription(),
                course.getCoordinator(),
                course.getUrl()
        );
    }

    public Course toEntity(CourseRequest request) {
        return Course.builder()
                .name(request.getName())
                .description(request.getDescription())
                .coordinator(request.getCoordinator())
                .url(request.getUrl())
                .build();
    }
}