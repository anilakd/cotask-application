package com.anilakdemir.cotaskapplication.dto.request.dashboard;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DashboardCreateRequest {

    @NotBlank
    private String title;
}
