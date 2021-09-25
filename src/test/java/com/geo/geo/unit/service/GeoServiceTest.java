package com.geo.geo.unit.service;

import com.geo.geo.domain.model.Geo;
import com.geo.geo.domain.repository.GeoRepository;
import com.geo.geo.service.GeoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GeoServiceTest {
    @Mock
    private GeoRepository geoRepository;

    @InjectMocks
    private GeoService geoService;

    private final String SUN = "SUN";
    private final String EARTH = "EARTH";
    private final String MARS = "MARS";
    private final String MOON = "MOON";
    private final String PHOBOS = "PHOBOS";

    @Test
    void testGetDistanceBetweenPlanets() {
        when(geoRepository.findById(EARTH)).thenReturn(buildEarth());
        when(geoRepository.findById(MARS)).thenReturn(buildMars());

        var response = geoService.findDistance(MARS, EARTH);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());

        var expectedRes = "Distance from MARS to EARTH is 200km";
        assertEquals(expectedRes, response.getBody());
    }

    @Test
    void testGetDistanceBetweenPlanetsReverse() {
        when(geoRepository.findById(EARTH)).thenReturn(buildEarth());
        when(geoRepository.findById(MARS)).thenReturn(buildMars());

        var responseAB = geoService.findDistance(EARTH, MARS);
        var responseBA = geoService.findDistance(EARTH, MARS);

        assertEquals(responseAB.getBody(), responseBA.getBody());
    }

    @Test
    void testGetDistanceBetweenMoons() {
        when(geoRepository.findById(EARTH)).thenReturn(buildEarth());
        when(geoRepository.findById(MARS)).thenReturn(buildMars());
        when(geoRepository.findById(MOON)).thenReturn(buildMoon());
        when(geoRepository.findById(PHOBOS)).thenReturn(buildPhobos());

        var response = geoService.findDistance(MOON, PHOBOS);

        var expectedRes = "Distance from MOON to PHOBOS is 260km";
        assertEquals(expectedRes, response.getBody());
    }

    @Test
    void testGetDistanceBetweenMoonAndEarth() {
        when(geoRepository.findById(EARTH)).thenReturn(buildEarth());
        when(geoRepository.findById(MOON)).thenReturn(buildMoon());

        var response = geoService.findDistance(MOON, EARTH);

        var expectedRes = "Distance from MOON to EARTH is 50km";
        assertEquals(expectedRes, response.getBody());
    }

    @Test
    void testGetDistanceBetweenMoonsReverse() {
        when(geoRepository.findById(EARTH)).thenReturn(buildEarth());
        when(geoRepository.findById(MARS)).thenReturn(buildMars());
        when(geoRepository.findById(MOON)).thenReturn(buildMoon());
        when(geoRepository.findById(PHOBOS)).thenReturn(buildPhobos());

        var responseAB = geoService.findDistance(MOON, PHOBOS);
        var responseBA = geoService.findDistance(MOON, PHOBOS);

        assertEquals(responseAB, responseBA);
    }

    @Test
    void testMissingPlanet() {
        when(geoRepository.findById(EARTH)).thenReturn(buildEarth());

        var response = geoService.findDistance(EARTH, MARS);

        assertEquals(response.getStatusCode(), HttpStatus.NOT_FOUND);
    }

    @Test
    void testMissingMoonOrbit() {
        when(geoRepository.findById(EARTH)).thenReturn(buildEarth());
        when(geoRepository.findById(MOON)).thenReturn(buildMoon());
        when(geoRepository.findById(PHOBOS)).thenReturn(buildPhobos());

        var response = geoService.findDistance(MOON, PHOBOS);

        assertEquals(response.getStatusCode(), HttpStatus.NOT_FOUND);
    }

    private Optional<Geo> buildEarth() {
        return Optional.of(buildGeo(EARTH, BigDecimal.valueOf(100), SUN, false));
    }
    private Optional<Geo> buildMoon() {
        return Optional.of(buildGeo(MOON, BigDecimal.valueOf(50), EARTH, true));
    }
    private Optional<Geo> buildMars() {
        return Optional.of(buildGeo(MARS, BigDecimal.valueOf(300), SUN, false));
    }
    private Optional<Geo> buildPhobos() {
        return Optional.of(buildGeo(PHOBOS, BigDecimal.valueOf(10), MARS, true));
    }
    private Geo buildGeo(String name, BigDecimal distance, String orbits, boolean isMoon) {
        return Geo.builder()
                .name(name)
                .distance(distance)
                .orbits(orbits)
                .isMoon(isMoon)
                .build();
    }
}
