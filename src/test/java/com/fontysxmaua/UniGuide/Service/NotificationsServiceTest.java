package com.fontysxmaua.UniGuide.Service;

import com.fontysxmaua.UniGuide.mapper.NotificationsMapper;
import com.fontysxmaua.UniGuide.model.entity.Notification;
import com.fontysxmaua.UniGuide.model.request.NotificationRequest;
import com.fontysxmaua.UniGuide.model.response.NotificationResponse;
import com.fontysxmaua.UniGuide.repository.NotificationRepository;
import com.fontysxmaua.UniGuide.service.NotificationsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

class NotificationsServiceTest {
    @Mock
    private NotificationRepository notificationRepository;

    @Mock
    private NotificationsMapper notificationsMapper;

    @InjectMocks
    private NotificationsService notificationsService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllNotifications() {
        when(notificationRepository.findAll()).thenReturn(Collections.singletonList(createSampleNotification()));
        when(notificationsMapper.toResponse(any())).thenReturn(createSampleNotificationResponse());

        List<NotificationResponse> result = notificationsService.getAllNotifications();

        assertEquals(1, ((List<?>) result).size());

        verify(notificationRepository, times(1)).findAll();
    }

    @Test
    void testAddNotification() {
        NotificationRequest request = createSampleNotificationRequest();
        Notification notification = createSampleNotification();
        NotificationResponse response = createSampleNotificationResponse();
        when(notificationsMapper.toEntity(request)).thenReturn(notification);
        when(notificationRepository.save(notification)).thenReturn(notification);
        when(notificationsMapper.toResponse(notification)).thenReturn(response);

        NotificationResponse result = notificationsService.addNotification(request);

        assertEquals(response, result);

        verify(notificationRepository, times(1)).save(notification);
        verify(notificationsMapper, times(1)).toEntity(request);
        verify(notificationsMapper, times(1)).toResponse(notification);
    }

    @Test
    void testDeleteNotification() {
        notificationsService.deleteNotification("sampleId");

        verify(notificationRepository, times(1)).deleteById("sampleId");
    }

    private Notification createSampleNotification() {
        return new Notification("sampleId", "Sender", "Subject", "Message", new Date());
    }

    private NotificationRequest createSampleNotificationRequest() {
        return new NotificationRequest("Sender", "Subject", "Message", new Date());
    }

    private NotificationResponse createSampleNotificationResponse() {
        return new NotificationResponse("sampleId", "Sender", "Subject", "Message", new Date());
    }
}
