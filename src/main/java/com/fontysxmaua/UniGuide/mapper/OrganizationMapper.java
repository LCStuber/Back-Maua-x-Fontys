package com.fontysxmaua.UniGuide.mapper;

import com.fontysxmaua.UniGuide.model.entity.Organization;
import com.fontysxmaua.UniGuide.model.request.OrganizationRequest;
import com.fontysxmaua.UniGuide.model.response.OrganizationResponse;
import org.springframework.stereotype.Component;

@Component
public class OrganizationMapper {
    public OrganizationResponse toResponse(Organization organization) {
        return new OrganizationResponse(
                organization.getId(),
                organization.getName(),
                organization.getDescription(),
                organization.getUrl(),
                organization.getInstagram()
        );
    }

    public Organization toEntity(OrganizationRequest request) {
        return Organization.builder()
                .name(request.getName())
                .description(request.getDescription())
                .url(request.getUrl())
                .instagram(request.getInstagram())
                .build();
    }
}