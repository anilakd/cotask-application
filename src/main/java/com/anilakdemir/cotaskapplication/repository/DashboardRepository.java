package com.anilakdemir.cotaskapplication.repository;

import com.anilakdemir.cotaskapplication.model.Dashboard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DashboardRepository extends JpaRepository<Dashboard, UUID> {
}
