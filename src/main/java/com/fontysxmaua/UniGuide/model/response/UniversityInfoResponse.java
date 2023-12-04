package com.fontysxmaua.UniGuide.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UniversityInfoResponse {
    private final String id;
    private final String Rector;
    private final String viceRector;
    private final String rectorImage;
    private final String viceRectorImage;
}