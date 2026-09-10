package com.swiss.trails.swisstrails_api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.swiss.trails.swisstrails_api.dto.TrailRequest;
import com.swiss.trails.swisstrails_api.dto.TrailResponse;
import com.swiss.trails.swisstrails_api.entity.Checkpoint;
import com.swiss.trails.swisstrails_api.entity.Trail;
import com.swiss.trails.swisstrails_api.exception.TrailNotFoundException;
import com.swiss.trails.swisstrails_api.repository.TrailRepository;

@Service
public class TrailService {

    private final TrailRepository trailRepository;

    public TrailService(final TrailRepository trailRepository) {
        this.trailRepository = trailRepository;
    }

    public List<TrailResponse> getAll() {
        return trailRepository.findAll().stream().map(this::toResponse).toList();
    }

    public List<TrailResponse> getAllWithDifficulty(final String difficulty) {
        return trailRepository.findByDifficulty(difficulty).stream().map(this::toResponse).toList();
    }

    public TrailResponse getTrailById(final Long id) {
        return toResponse(trailRepository.findById(id).orElseThrow(() -> new TrailNotFoundException(id))); 
    }

    public TrailResponse getTrailByName(final String name) {
        return toResponse(trailRepository.findByName(name).orElseThrow(() -> new TrailNotFoundException(name)));
    }

    public TrailResponse createOrUpdateTrail(final Long id, final TrailRequest trailRequest) {
        if (id != null) {
            return saveTrail(trailRepository.findById(id).orElseThrow(() -> new TrailNotFoundException(id)), trailRequest);
        } else {
            return saveTrail(new Trail(), trailRequest);
        }
    }

    private TrailResponse saveTrail(final Trail trail, final TrailRequest trailRequest) {
        if (trailRequest.name() != null) {
            trail.setName(trailRequest.name());
        }
        if (trailRequest.lengthKm() != null) {
            trail.setLengthKm(trailRequest.lengthKm());
        }
        if (trailRequest.elevation() != null) {
            trail.setElevation(trailRequest.elevation());
        }
        if (trailRequest.difficulty() != null) {
            trail.setDifficulty(trailRequest.difficulty());
        }
        if (trailRequest.checkpointNames() != null) {
            for (final Checkpoint checkpoint : trailRequest.checkpointNames()) {
                checkpoint.setTrail(trail);
                trail.getCheckpoints().add(checkpoint);
            }
        }
        return toResponse(trailRepository.save(trail));
    }
    
    public void deleteTrail(final Long id) {
        trailRepository.delete(trailRepository.findById(id).orElseThrow(() -> new TrailNotFoundException(id)));
    }

    private TrailResponse toResponse(final Trail trail) {
        return new TrailResponse(trail.getId(), trail.getName(), trail.getLengthKm(), trail.getElevation(),trail.getDifficulty(), trail.getCheckpoints().stream().map((c) -> c.getName()).toList()); 
    }

}
