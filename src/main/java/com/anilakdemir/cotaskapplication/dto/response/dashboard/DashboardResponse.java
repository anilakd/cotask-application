package com.anilakdemir.cotaskapplication.dto.response.dashboard;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class DashboardResponse {

    private UUID id;
    private String title;
}
