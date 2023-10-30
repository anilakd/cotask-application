package com.anilakdemir.cotaskapplication.mapper;

import com.anilakdemir.cotaskapplication.dto.request.dashboard.DashboardCreateRequest;
import com.anilakdemir.cotaskapplication.dto.response.dashboard.DashboardResponse;
import com.anilakdemir.cotaskapplication.model.Dashboard;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DashboardMapper {

    Dashboard toDashboard(DashboardCreateRequest dashboardCreateRequest);
    DashboardResponse toDashboardResponse(Dashboard dashboard);
}
