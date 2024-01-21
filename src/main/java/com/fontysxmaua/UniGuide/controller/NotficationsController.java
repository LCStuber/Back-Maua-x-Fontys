package com.fontysxmaua.UniGuide.controller;

import com.fontysxmaua.UniGuide.model.request.NotificationRequest;
import com.fontysxmaua.UniGuide.model.response.NotificationResponse;
import com.fontysxmaua.UniGuide.service.FirebaseMessagingService;
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
    private FirebaseMessagingService firebaseMessagingService;
    
    @GetMapping
    public ResponseEntity<List<NotificationResponse>> getAllNotifications() {
        return ResponseEntity.ok(service.getAllNotifications());
    }

    @PostMapping("/addNotification")
    public ResponseEntity<NotificationResponse> addNotification(
            @RequestBody @Valid NotificationRequest request){
        System.out.println("Received notification request: " + request.toString());
        return ResponseEntity.ok(service.addNotification(request));  //remove token
    }

    @PostMapping("/sendNotification")
    public String sendNotification(
            @RequestBody @Valid NotificationRequest request,
            @RequestParam("token") String token) throws FirebaseMessagingException {
        return firebaseMessagingService.sendNotification(request, token);  //request token separate from notification
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotification(@PathVariable String id) {
        service.deleteNotification(id);
        return ResponseEntity.ok().build();
    }

}
