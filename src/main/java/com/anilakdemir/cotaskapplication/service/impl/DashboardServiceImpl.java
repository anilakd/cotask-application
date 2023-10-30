package com.anilakdemir.cotaskapplication.service.impl;

import com.anilakdemir.cotaskapplication.dto.request.dashboard.DashboardCreateRequest;
import com.anilakdemir.cotaskapplication.dto.response.ApiResponse;
import com.anilakdemir.cotaskapplication.dto.response.dashboard.DashboardResponse;
import com.anilakdemir.cotaskapplication.exception.DashboardNotFoundException;
import com.anilakdemir.cotaskapplication.mapper.DashboardMapper;
import com.anilakdemir.cotaskapplication.model.Dashboard;
import com.anilakdemir.cotaskapplication.repository.DashboardRepository;
import com.anilakdemir.cotaskapplication.service.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

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

    @Override
    public ApiResponse<DashboardResponse> updateTitle(UUID id, String title) {

        Dashboard dashboard = getDashboardById(id);
        dashboard.setTitle(title);

        Dashboard updatedDashboard = dashboardRepository.save(dashboard);

        DashboardResponse response = dashboardMapper.toDashboardResponse(updatedDashboard);
        return ApiResponse.success(response);
    }

    @Override
    public ApiResponse<String> deleteById(UUID id) {
        Dashboard dashboard = getDashboardById(id);
        dashboardRepository.delete(dashboard);
        return ApiResponse.success(String.format("Successfully deleted by id: %s", id));
    }

    private Dashboard getDashboardById(UUID id) {
        return dashboardRepository.findById(id)
                .orElseThrow(() -> new DashboardNotFoundException("id", id.toString()));
    }
}
