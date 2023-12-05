package com.fontysxmaua.UniGuide.service;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fontysxmaua.UniGuide.mapper.NotificationsMapper;
import com.fontysxmaua.UniGuide.model.entity.Notification;
import com.fontysxmaua.UniGuide.model.request.NotificationRequest;
import com.fontysxmaua.UniGuide.model.response.NotificationResponse;
import com.fontysxmaua.UniGuide.repository.NotificationRepository;

@Service
@RequiredArgsConstructor
public class NotificationsService {

    private final NotificationRepository notificationRepository;
    private final NotificationsMapper notificationsMapper;

    public List<NotificationResponse> getAllNotifications() {
        return ((List<Notification>) notificationRepository.findAll())
                .stream()
                .map(notificationsMapper::toResponse)
                .toList();
    }

    public NotificationResponse addNotification(NotificationRequest request) {
        final var notification = notificationsMapper.toEntity(request);
        final var savedNotification = notificationRepository.save(notification);

        return notificationsMapper.toResponse(savedNotification);
    }

    public void deleteNotification(String id) {
        notificationRepository.deleteById(id);
    }
}
