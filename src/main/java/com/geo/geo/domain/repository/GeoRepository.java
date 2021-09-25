package com.geo.geo.domain.repository;

import com.geo.geo.domain.model.Geo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeoRepository extends JpaRepository<Geo, String> {
}
