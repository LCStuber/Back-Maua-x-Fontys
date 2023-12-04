package com.fontysxmaua.UniGuide.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UniversityInfoRequest {

    @NotBlank(message = "Rector's name is required")
    private String rector;

    @NotBlank(message = "Vice Rector's name is required")
    private String viceRector;

    @NotBlank(message = "Rector's image URL is required")
    private String rectorImage;

    @NotBlank(message = "Vice Rector's image URL is required")
    private String viceRectorImage;
}