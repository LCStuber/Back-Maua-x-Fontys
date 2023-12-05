package com.fontysxmaua.UniGuide.repository;

import com.fontysxmaua.UniGuide.model.entity.Notification;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface NotificationRepository extends CrudRepository<Notification, String>{
}
