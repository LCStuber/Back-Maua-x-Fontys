package com.fontysxmaua.UniGuide.controller;

import com.fontysxmaua.UniGuide.model.request.ActivityRequest;
import com.fontysxmaua.UniGuide.model.response.ActivityResponse;
import com.fontysxmaua.UniGuide.service.ActivitiesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/activities")
@RequiredArgsConstructor
public class ActivitiesController {

    private final ActivitiesService service;

    @GetMapping
    public ResponseEntity<List<ActivityResponse>> getAllActivities() {
        return ResponseEntity.ok(service.getAllActivities());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActivityResponse> getActivityById(@PathVariable String id) {
        return ResponseEntity.ok(service.getActivityById(id));
    }

    @GetMapping("/{email}")
    public ResponseEntity<List<ActivityResponse>> getAllActivitiesByEmail(@PathVariable String email){
        return ResponseEntity.ok(service.getAllActivitiesByEmail(email));
    }

    @PostMapping("/{id}/addAttending/{personEmail}")
    public ResponseEntity<ActivityResponse> addAttendingById(@PathVariable String id, @PathVariable String personEmail) {
        return ResponseEntity.ok(service.addPersonToActivity(id, personEmail));
    }

    @PostMapping("/{id}/addSubscribed/{personEmail}")
    public ResponseEntity<ActivityResponse> addSubscribedById(@PathVariable String id, @PathVariable String personEmail) {
        return ResponseEntity.ok(service.subscribePersonToActivity(id, personEmail));
    }

    @PostMapping("/{id}/removeSubscribed/{personEmail}")
    public ResponseEntity<ActivityResponse> removeSubscribedById(@PathVariable String id, @PathVariable String personEmail){
        return ResponseEntity.ok(service.unsubscribePersonFromActivity(id, personEmail));
    }

    @PostMapping
    public ResponseEntity<ActivityResponse> addActivity(
            @RequestBody @Valid ActivityRequest request
    ) {
        return ResponseEntity.ok(service.addActivity(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActivity(@PathVariable String id) {
        service.deleteActivity(id);
        return ResponseEntity.ok().build();
    }
}
