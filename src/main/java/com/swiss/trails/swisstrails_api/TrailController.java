package com.swiss.trails.swisstrails_api;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrailController {
    private final TrailService trailService;

    public TrailController(TrailService trailService) {
        this.trailService = trailService;
    }

}
