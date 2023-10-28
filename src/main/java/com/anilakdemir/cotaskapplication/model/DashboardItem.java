package com.anilakdemir.cotaskapplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "dashboard_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DashboardItem extends BaseEntity {

    private String content;

    //private Category category;

}
