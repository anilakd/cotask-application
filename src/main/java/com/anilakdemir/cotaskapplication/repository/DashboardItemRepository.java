package com.anilakdemir.cotaskapplication.repository;

import com.anilakdemir.cotaskapplication.model.DashboardItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DashboardItemRepository extends JpaRepository<DashboardItem, UUID> {
}
