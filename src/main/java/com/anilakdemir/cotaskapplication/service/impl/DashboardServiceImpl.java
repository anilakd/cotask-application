package com.anilakdemir.cotaskapplication.service.impl;

import com.anilakdemir.cotaskapplication.dto.request.dashboard.DashboardCreateRequest;
import com.anilakdemir.cotaskapplication.dto.response.ApiResponse;
import com.anilakdemir.cotaskapplication.dto.response.dashboard.DashboardResponse;
import com.anilakdemir.cotaskapplication.mapper.DashboardMapper;
import com.anilakdemir.cotaskapplication.model.Dashboard;
import com.anilakdemir.cotaskapplication.repository.DashboardRepository;
import com.anilakdemir.cotaskapplication.service.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DashboardServiceImpl implements DashboardService {

    private final DashboardRepository dashboardRepository;
    private final DashboardMapper dashboardMapper;

    @Override
    public ApiResponse<DashboardResponse> save(DashboardCreateRequest dashboardCreateRequest) {
        Dashboard dashboard = dashboardMapper.toDashboard(dashboardCreateRequest);

        Dashboard savedDashboard = dashboardRepository.save(dashboard);

        DashboardResponse response = dashboardMapper.toDashboardResponse(savedDashboard);

        return ApiResponse.success(response);
    }
}
