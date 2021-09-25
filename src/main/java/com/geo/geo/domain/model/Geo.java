package com.geo.geo.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "geo")
public class Geo {
    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "distance", nullable = false)
    private BigDecimal distance;

    @Column(name = "orbits")
    private String orbits;

    @Column(name = "isMoon", nullable = false)
    private boolean isMoon;
}
