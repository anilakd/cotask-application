package com.anilakdemir.cotaskapplication.service.impl;

import com.anilakdemir.cotaskapplication.repository.DashboardItemRepository;
import com.anilakdemir.cotaskapplication.service.DashboardItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DashboardItemServiceImpl implements DashboardItemService {

    private final DashboardItemRepository dashboardItemRepository;
}
