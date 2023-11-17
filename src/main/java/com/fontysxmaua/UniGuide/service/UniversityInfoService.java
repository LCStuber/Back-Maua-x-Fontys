package com.fontysxmaua.UniGuide.service;


import com.fontysxmaua.UniGuide.mapper.UniversityInfoMapper;
import com.fontysxmaua.UniGuide.model.entity.UniversityInfo;
import com.fontysxmaua.UniGuide.model.request.UniversityInfoRequest;
import com.fontysxmaua.UniGuide.model.response.UniversityInfoResponse;
import com.fontysxmaua.UniGuide.repository.UniversityInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UniversityInfoService {

    private final UniversityInfoRepository universityInfoRepository;

    private final UniversityInfoMapper universityInfoMapper;

    public List<UniversityInfoResponse> getUniversityInfo() {
        return ((List<UniversityInfo>) universityInfoRepository.findAll())
                .stream()
                .map(universityInfoMapper::toResponse)
                .toList();
    }

    public UniversityInfoResponse updateUniversityInfo(String id, UniversityInfoRequest request) {
        final var newUniversityInfo = universityInfoMapper.toEntity(request);
        final var oldUniversityInfo = universityInfoRepository.findById(id).get();

        oldUniversityInfo.setRector(newUniversityInfo.getRector());
        oldUniversityInfo.setViceRector(newUniversityInfo.getViceRector());

        final var savedUniversityInfo = universityInfoRepository.save(oldUniversityInfo);

        return universityInfoMapper.toResponse(savedUniversityInfo);
    }
}
