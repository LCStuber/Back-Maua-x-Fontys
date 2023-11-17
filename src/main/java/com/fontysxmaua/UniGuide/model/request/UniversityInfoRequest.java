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
    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Rector's name is required")
    private String rector;

    @NotBlank(message = "Vice Rector's name is required")
    private String viceRector;
}