package com.fontysxmaua.UniGuide.service;

import com.fontysxmaua.UniGuide.mapper.OrganizationMapper;
import com.fontysxmaua.UniGuide.model.entity.Organization;
import com.fontysxmaua.UniGuide.model.request.OrganizationRequest;
import com.fontysxmaua.UniGuide.model.response.OrganizationResponse;
import com.fontysxmaua.UniGuide.repository.OrganizationRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizationsService {

    private final OrganizationRepository organizationRepository;

    private final OrganizationMapper organizationMapper;

    public List<OrganizationResponse> getAllOrganizations() {
        return ((List<Organization>) organizationRepository.findAll())
                .stream()
                .map(organizationMapper::toResponse)
                .toList();
    }

    public OrganizationResponse addOrganization(OrganizationRequest request) {
        final var organization = organizationMapper.toEntity(request);
        final var savedOrganization = organizationRepository.save(organization);

        return organizationMapper.toResponse(savedOrganization);
    }

    public void deleteOrganization(String id) {
        organizationRepository.deleteById(id);
    }

    public OrganizationResponse updateOrganization(String id, OrganizationRequest request) {
        final var newOrganization = organizationMapper.toEntity(request);
        final var oldOrganization = organizationRepository.findById(id).get();

        oldOrganization.setName(newOrganization.getName());
        oldOrganization.setDescription(newOrganization.getDescription());
        oldOrganization.setUrl(newOrganization.getUrl());
        oldOrganization.setInstagram(newOrganization.getInstagram());

        final var savedOrganization = organizationRepository.save(oldOrganization);

        return organizationMapper.toResponse(savedOrganization);
    }
}
