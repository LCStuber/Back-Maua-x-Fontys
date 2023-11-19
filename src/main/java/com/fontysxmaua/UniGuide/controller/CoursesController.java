package com.fontysxmaua.UniGuide.controller;

import com.fontysxmaua.UniGuide.model.request.CourseRequest;
import com.fontysxmaua.UniGuide.model.response.CourseResponse;
import com.fontysxmaua.UniGuide.service.CoursesService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
public class CoursesController {

    private final CoursesService service;

    @GetMapping
    public ResponseEntity<List<CourseResponse>> getAllCourses() {
        return ResponseEntity.ok(service.getAllCourses());
    }

    @PostMapping
    public ResponseEntity<CourseResponse> addCourse(
            @RequestBody @Valid CourseRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addCourse(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable String id) {
        service.deleteCourse(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseResponse> updateCourse(@PathVariable String id,
            @RequestBody @Valid CourseRequest request) {
        return ResponseEntity.ok(service.updateCourse(id,request));
    }
}
