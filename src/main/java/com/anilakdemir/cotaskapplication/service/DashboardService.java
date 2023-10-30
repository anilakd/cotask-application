package com.anilakdemir.cotaskapplication.service;

import com.anilakdemir.cotaskapplication.dto.request.dashboard.DashboardCreateRequest;
import com.anilakdemir.cotaskapplication.dto.response.ApiResponse;
import com.anilakdemir.cotaskapplication.dto.response.dashboard.DashboardResponse;

import java.util.UUID;

public interface DashboardService {
    ApiResponse<DashboardResponse> save(DashboardCreateRequest dashboardCreateRequest);

    ApiResponse<DashboardResponse> updateTitle(UUID id, String name);

    ApiResponse<String> deleteById(UUID id);
}
