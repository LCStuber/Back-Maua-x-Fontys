package com.fontysxmaua.UniGuide.repository;

import com.fontysxmaua.UniGuide.model.entity.Course;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface CourseRepository extends CrudRepository<Course, String> {
}