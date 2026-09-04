package com.swiss.trails.swisstrails_api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/trails")
public class TrailController {
    private final TrailService trailService;

    public TrailController(TrailService trailService) {
        this.trailService = trailService;
    }

    @GetMapping 
    public List<String> listTrails() {
        return List.of("Fünf-Seen-Wanderung", "Aletsch Panoramaweg");
    }

    @GetMapping("/{name}")
    public String getTrail(@PathVariable String name) {
        return "Details of " + name;
    }
}
