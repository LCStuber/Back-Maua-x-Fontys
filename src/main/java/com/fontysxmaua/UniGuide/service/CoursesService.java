package com.fontysxmaua.UniGuide.service;

import com.fontysxmaua.UniGuide.mapper.CourseMapper;
import com.fontysxmaua.UniGuide.model.entity.Course;
import com.fontysxmaua.UniGuide.model.request.CourseRequest;
import com.fontysxmaua.UniGuide.model.response.CourseResponse;
import com.fontysxmaua.UniGuide.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CoursesService {

    private final CourseRepository courseRepository;

    private final CourseMapper courseMapper;

    public List<CourseResponse> getAllCourses() {
        return ((List<Course>) courseRepository.findAll())
                .stream()
                .map(courseMapper::toResponse)
                .toList();
    }

    public CourseResponse addCourse(CourseRequest request) {
        final var course = courseMapper.toEntity(request);
        final var savedCourse = courseRepository.save(course);

        return courseMapper.toResponse(savedCourse);
    }

    public void deleteCourse(String id) {
        courseRepository.deleteById(id);
    }

    public CourseResponse updateCourse(String id, CourseRequest request) {
        final var newCourse = courseMapper.toEntity(request);
        final var oldCourse = courseRepository.findById(id).get();

        oldCourse.setName(newCourse.getName());
        oldCourse.setCoordinator(newCourse.getCoordinator());
        oldCourse.setCoordinatorImage(newCourse.getCoordinatorImage());
        oldCourse.setCoordinatorEmail(newCourse.getCoordinatorEmail());
        oldCourse.setUrl(newCourse.getUrl());
        oldCourse.setDescription(newCourse.getDescription());
        oldCourse.setDisplayImage(newCourse.getDisplayImage());

        final var savedCourse = courseRepository.save(oldCourse);

        return courseMapper.toResponse(savedCourse);
    }
}
