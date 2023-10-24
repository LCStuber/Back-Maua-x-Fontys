package com.fontysxmaua.UniGuide.controller;

import com.fontysxmaua.UniGuide.model.request.ActivityRequest;
import com.fontysxmaua.UniGuide.model.response.ActivityResponse;
import com.fontysxmaua.UniGuide.service.ActivitiesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<ActivityResponse> addProductInfo(
            @RequestBody @Valid ActivityRequest productInfo
    ) {
        return ResponseEntity.ok(service.addProductInfo(productInfo));
    }
}
