package com.anilakdemir.cotaskapplication.controller;

import com.anilakdemir.cotaskapplication.dto.request.dashboard.DashboardCreateRequest;
import com.anilakdemir.cotaskapplication.dto.response.ApiResponse;
import com.anilakdemir.cotaskapplication.dto.response.dashboard.DashboardResponse;
import com.anilakdemir.cotaskapplication.service.DashboardService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/dashboards")
@RequiredArgsConstructor
@Validated
public class DashboardController {

    private final DashboardService dashboardService;

    @PostMapping
    public ResponseEntity<ApiResponse<DashboardResponse>> create(@Valid @RequestBody DashboardCreateRequest dashboardCreateRequest) {
        ApiResponse<DashboardResponse> response = dashboardService.save(dashboardCreateRequest);
        return ResponseEntity.ok(response);
    }

    @PatchMapping
    public ResponseEntity<ApiResponse<DashboardResponse>> updateTitle(@Valid @NotNull @RequestParam UUID id, @RequestParam @NotBlank String title) {
        ApiResponse<DashboardResponse> response = dashboardService.updateTitle(id, title);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping
    public ResponseEntity<ApiResponse<String>> deleteById(@Valid @NotNull @RequestParam UUID id) {
        ApiResponse<String> response = dashboardService.deleteById(id);
        return ResponseEntity.ok(response);
    }
}
