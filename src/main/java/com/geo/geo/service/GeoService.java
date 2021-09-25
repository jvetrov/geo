package com.geo.geo.service;

import com.geo.geo.controller.GeoController;
import com.geo.geo.domain.model.Geo;
import com.geo.geo.domain.repository.GeoRepository;
import com.google.common.collect.Lists;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

@Slf4j
@RestController
@AllArgsConstructor
public class GeoService implements GeoController {
    private final GeoRepository geoRepository;

    @Override
    public ResponseEntity<String> findDistance(String from, String to) {
        try {
            var res = calculateDistance(from, to);
            return ResponseEntity.ok("Distance from " + from + " to " + to + " is " + res + "km");
        } catch (NotFoundException ex) {
            log.error(ex.getMessage(), ex);
            return ResponseEntity.notFound().build();
        }
    }

    private BigDecimal calculateDistance(String from, String to) throws NotFoundException {
        var geoListFrom = collectGeoList(from, Lists.newArrayList());
        var geoListTo = collectGeoList(to, Lists.newArrayList());
        return Stream.concat(geoListFrom.stream(), geoListTo.stream())
                .sorted(Comparator.comparing(Geo::isMoon, Boolean::compare))
                .reduce(BigDecimal.ZERO,
                        (acc, elem) -> elem.isMoon() ? acc.add(elem.getDistance()) : acc.subtract(elem.getDistance()).abs(),
                        BigDecimal::add
                );
    }

    private List<Geo> collectGeoList(String name, List<Geo> geoList) throws NotFoundException {
        var geo = geoRepository.findById(name.toUpperCase()).orElseThrow(() -> new NotFoundException("Planet not found " + name));
        geoList.add(geo);
        if (geo.isMoon()) {
            return collectGeoList(geo.getOrbits(), geoList);
        }
        return geoList;
    }
}
