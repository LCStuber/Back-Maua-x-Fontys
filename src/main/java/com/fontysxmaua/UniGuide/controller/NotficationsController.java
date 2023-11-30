package com.fontysxmaua.UniGuide.controller;

import com.fontysxmaua.UniGuide.model.request.NotificationRequest;
import com.fontysxmaua.UniGuide.model.response.NotificationResponse;
import com.fontysxmaua.UniGuide.service.NotificationsService;

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
    
    @GetMapping
    public ResponseEntity<List<NotificationResponse>> getAllNotifications() {
        return ResponseEntity.ok(service.getAllNotifications());
    }

    @PostMapping
    public ResponseEntity<NotificationResponse> addNotification(
            @RequestBody @Valid NotificationRequest request) {
        return ResponseEntity.ok(service.addNotification(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotification(@PathVariable String id) {
        service.deleteNotification(id);
        return ResponseEntity.ok().build();
    }
}
