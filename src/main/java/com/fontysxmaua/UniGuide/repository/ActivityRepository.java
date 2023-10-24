package com.fontysxmaua.UniGuide.repository;

import com.fontysxmaua.UniGuide.model.entity.Activity;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface ActivityRepository extends CrudRepository<Activity, String> {
}