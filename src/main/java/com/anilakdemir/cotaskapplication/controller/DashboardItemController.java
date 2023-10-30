package com.anilakdemir.cotaskapplication.controller;

import com.anilakdemir.cotaskapplication.service.DashboardItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/dashboard-items")
@RequiredArgsConstructor
public class DashboardItemController {

    private final DashboardItemService dashboardItemService;
}
