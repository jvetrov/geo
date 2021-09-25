package com.geo.geo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface GeoController {
    @GetMapping(path = "/distance/{from}/{to}")
    ResponseEntity<String> findDistance(
            @PathVariable("from") String from,
            @PathVariable("to") String to
    );
}
