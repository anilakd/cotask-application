package com.anilakdemir.cotaskapplication.controller;

import com.anilakdemir.cotaskapplication.dto.request.dashboard.DashboardCreateRequest;
import com.anilakdemir.cotaskapplication.dto.response.ApiResponse;
import com.anilakdemir.cotaskapplication.dto.response.dashboard.DashboardResponse;
import com.anilakdemir.cotaskapplication.service.DashboardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/dashboards")
@RequiredArgsConstructor
public class DashboardController {

    private final DashboardService dashboardService;

    @PostMapping
    public ResponseEntity<ApiResponse<DashboardResponse>> create(@Valid @RequestBody DashboardCreateRequest dashboardCreateRequest) {
        ApiResponse<DashboardResponse> response = dashboardService.save(dashboardCreateRequest);
        return ResponseEntity.ok(response);
    }
}
