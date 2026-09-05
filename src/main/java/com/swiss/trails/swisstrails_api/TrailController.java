package com.swiss.trails.swisstrails_api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.swiss.trails.swisstrails_api.dto.TrailRequest;
import com.swiss.trails.swisstrails_api.dto.TrailResponse;

@RestController
@RequestMapping("/api/trails")
public class TrailController {
    private final TrailService trailService;

    public TrailController(TrailService trailService) {
        this.trailService = trailService;
    }

    @GetMapping 
    public List<TrailResponse> listTrails(@RequestParam(required = false) String diffuculty) {
        if (diffuculty != null) {
            return trailService.getAllWithDifficulty(diffuculty);
        }
        return trailService.getAll();
    }

    @GetMapping("/{name}")
    public String getTrail(@PathVariable String name) {
        return "Details of " + name;
    }

    @PostMapping 
    public ResponseEntity<String> addTrail(@RequestBody TrailRequest request) {
        TrailResponse trailResponse = trailService.createTrail(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("Added: " + trailResponse.name());
    }
}
