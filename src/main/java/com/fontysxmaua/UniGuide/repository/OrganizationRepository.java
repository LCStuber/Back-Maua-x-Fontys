package com.fontysxmaua.UniGuide.repository;

import com.fontysxmaua.UniGuide.model.entity.Organization;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface OrganizationRepository extends CrudRepository<Organization, String> {
}