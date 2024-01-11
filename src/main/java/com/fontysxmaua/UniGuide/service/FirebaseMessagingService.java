package com.fontysxmaua.UniGuide.service;

import com.fontysxmaua.UniGuide.model.request.NotificationRequest;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import org.springframework.stereotype.Service;

@Service
public class FirebaseMessagingService {
    private final FirebaseMessaging firebaseMessaging;

    public FirebaseMessagingService(FirebaseMessaging firebaseMessaging){
        this.firebaseMessaging = firebaseMessaging;
    }

    public String sendNotification(NotificationRequest request) throws FirebaseMessagingException {
        Notification notification = Notification
                .builder()
                .setTitle(request.getSender())
                .setBody(request.getSubject())
                .build();

        Message message = Message
                .builder()
                .setToken(request.getDeviceToken())
                .setNotification(notification)
                .build();

        return firebaseMessaging.send(message);
    }
}
