package com.fontysxmaua.UniGuide.mapper;

import com.fontysxmaua.UniGuide.model.entity.Notification;
import com.fontysxmaua.UniGuide.model.request.NotificationRequest;
import com.fontysxmaua.UniGuide.model.response.NotificationResponse;
import org.springframework.stereotype.Component;

@Component
public class NotificationsMapper {
    public NotificationResponse toResponse(Notification notification) {
        return new NotificationResponse(
                notification.getId(),
                notification.getSender(),
                notification.getSubject(),
                notification.getMessage(),
                notification.getDateCreated()
        );
    }

    public Notification toEntity(NotificationRequest request) {
        return Notification.builder()
                .sender(request.getSender())
                .subject(request.getSubject())
                .message(request.getMessage())
                .dateCreated(request.getDateCreated())
                .build();
    }
}
