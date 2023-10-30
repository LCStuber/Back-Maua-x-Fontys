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
