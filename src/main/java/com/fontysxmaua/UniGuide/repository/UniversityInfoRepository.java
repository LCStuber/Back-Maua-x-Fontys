package com.fontysxmaua.UniGuide.repository;

import com.fontysxmaua.UniGuide.model.entity.UniversityInfo;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface UniversityInfoRepository extends CrudRepository<UniversityInfo, String> {
}