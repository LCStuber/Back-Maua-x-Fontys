package com.fontysxmaua.UniGuide.controller;

import com.fontysxmaua.UniGuide.model.request.NotificationRequest;
import com.fontysxmaua.UniGuide.model.response.NotificationResponse;
import com.fontysxmaua.UniGuide.service.NotificationsService;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/notifications")
@RequiredArgsConstructor
public class NotficationsController {

    private final NotificationsService service;
    private FirebaseMessaging firebaseMessaging;
    
    @GetMapping
    public ResponseEntity<List<NotificationResponse>> getAllNotifications() {
        return ResponseEntity.ok(service.getAllNotifications());
    }

    @PostMapping("/send-notification")
    public ResponseEntity<NotificationResponse> addNotification(
            @RequestBody @Valid NotificationRequest request){
        sendPushNotification(request);
        return ResponseEntity.ok(service.addNotification(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotification(@PathVariable String id) {
        service.deleteNotification(id);
        return ResponseEntity.ok().build();
    }
    private void sendPushNotification(NotificationRequest request){
        try {
            Message message = Message.builder()
                    .putData("subject", request.getSubject())
                    .putData("sender", request.getSender())
                    .setToken(request.getDeviceToken())
                    .build();
            String response = firebaseMessaging.send(message);
            System.out.println("Push notification sent. Response: " + response);
        } catch (FirebaseMessagingException e) {
            System.err.println("Error sending push notification: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
