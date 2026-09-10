package com.swiss.trails.swisstrails_api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.swiss.trails.swisstrails_api.dto.TrailRequest;
import com.swiss.trails.swisstrails_api.dto.TrailResponse;
import com.swiss.trails.swisstrails_api.service.TrailService;

@RestController
@RequestMapping("/api/trails")
public class TrailController {
    private final TrailService trailService;

    public TrailController(final TrailService trailService) {
        this.trailService = trailService;
    }

    @PostMapping
    public ResponseEntity<String> addTrail(@Validated(TrailRequest.OnCreate.class) @RequestBody TrailRequest trailRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body("Added: " + trailService.createOrUpdateTrail(null, trailRequest).name());
    }

    @GetMapping 
    public ResponseEntity<List<TrailResponse>> listTrails(@RequestParam(required = false) String difficulty) {
        if (difficulty != null) {
            return ResponseEntity.status(HttpStatus.OK).body(trailService.getAllWithDifficulty(difficulty));
        }
        return ResponseEntity.status(HttpStatus.OK).body(trailService.getAll());
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<TrailResponse> getTrail(@PathVariable String name) {
        return ResponseEntity.status(HttpStatus.OK).body(trailService.getTrailByName(name));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrailResponse> findTrailById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(trailService.getTrailById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrailResponse> updateTrail(@PathVariable Long id,@Validated @RequestBody TrailRequest trailRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(trailService.createOrUpdateTrail(id, trailRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTrail(@PathVariable Long id) {
        trailService.deleteTrail(id);
        return ResponseEntity.status(HttpStatus.OK).body("Trail was successfully deleted");
    }
}
