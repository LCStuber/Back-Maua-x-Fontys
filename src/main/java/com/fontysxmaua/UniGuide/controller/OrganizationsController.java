package com.fontysxmaua.UniGuide.controller;

import com.fontysxmaua.UniGuide.model.request.OrganizationRequest;
import com.fontysxmaua.UniGuide.model.response.OrganizationResponse;
import com.fontysxmaua.UniGuide.service.OrganizationsService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/organizations")
@RequiredArgsConstructor
public class OrganizationsController {

    private final OrganizationsService service;

    @GetMapping
    public ResponseEntity<List<OrganizationResponse>> getAllOrganizations() {
        return ResponseEntity.ok(service.getAllOrganizations());
    }

    @PostMapping
    public ResponseEntity<OrganizationResponse> addOrganization(
            @RequestBody @Valid OrganizationRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addOrganization(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrganization(@PathVariable String id) {
        service.deleteOrganization(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrganizationResponse> updateOrganization(@PathVariable String id,
            @RequestBody @Valid OrganizationRequest request) {
        return ResponseEntity.ok(service.updateOrganization(id,request));
    }
}
