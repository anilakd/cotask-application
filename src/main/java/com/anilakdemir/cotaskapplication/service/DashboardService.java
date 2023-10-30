package com.anilakdemir.cotaskapplication.service;

import com.anilakdemir.cotaskapplication.dto.request.dashboard.DashboardCreateRequest;
import com.anilakdemir.cotaskapplication.dto.response.ApiResponse;
import com.anilakdemir.cotaskapplication.dto.response.dashboard.DashboardResponse;

public interface DashboardService {
    ApiResponse<DashboardResponse> save(DashboardCreateRequest dashboardCreateRequest);
}
