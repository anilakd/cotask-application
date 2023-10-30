package com.anilakdemir.cotaskapplication.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "dashboards")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dashboard extends BaseEntity {

    @Column(nullable = false)
    private String title;

}
