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
                course.getCoordinator(),
                course.getCoordinatorImage(),
                course.getCoordinatorEmail(),
                course.getUrl(),
                course.getDescription()
        );
    }

    public Course toEntity(CourseRequest request) {
        return Course.builder()
                .name(request.getName())
                .coordinator(request.getCoordinator())
                .coordinatorImage(request.getCoordinatorLink())
                .coordinatorEmail(request.getCoordinatorEmail())
                .url(request.getUrl())
                .description(request.getDescription())
                .build();
    }
}