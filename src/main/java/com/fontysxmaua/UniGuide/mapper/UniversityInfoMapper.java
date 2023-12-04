package com.fontysxmaua.UniGuide.mapper;

import com.fontysxmaua.UniGuide.model.entity.UniversityInfo;
import com.fontysxmaua.UniGuide.model.request.UniversityInfoRequest;
import com.fontysxmaua.UniGuide.model.response.UniversityInfoResponse;

import org.springframework.stereotype.Component;

@Component
public class UniversityInfoMapper {
    public UniversityInfoResponse toResponse(UniversityInfo universityInfo) {
        return new UniversityInfoResponse(
                universityInfo.getId(),
                universityInfo.getRector(),
                universityInfo.getViceRector(),
                universityInfo.getRectorImage(),
                universityInfo.getViceRectorImage()
        );
    }

    public UniversityInfo toEntity(UniversityInfoRequest request) {
        return UniversityInfo.builder()
                .rector(request.getRector())
                .viceRector(request.getViceRector())
                .rectorImage(request.getRectorImage())
                .viceRectorImage(request.getViceRectorImage())
                .build();
    }
}