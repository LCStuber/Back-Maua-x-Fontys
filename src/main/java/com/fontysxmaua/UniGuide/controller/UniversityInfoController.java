package com.fontysxmaua.UniGuide.controller;

import com.fontysxmaua.UniGuide.model.request.UniversityInfoRequest;
import com.fontysxmaua.UniGuide.model.response.UniversityInfoResponse;
import com.fontysxmaua.UniGuide.service.UniversityInfoService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/universityinfo")
@RequiredArgsConstructor
public class UniversityInfoController {

    private final UniversityInfoService service;

    @GetMapping
    public ResponseEntity<List<UniversityInfoResponse>> getUniversityInfo() {
        return ResponseEntity.ok(service.getUniversityInfo());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UniversityInfoResponse> updateUniversityInfo(@PathVariable String id,
            @RequestBody @Valid UniversityInfoRequest request) {
        return ResponseEntity.ok(service.updateUniversityInfo(id,request));
    }
}
