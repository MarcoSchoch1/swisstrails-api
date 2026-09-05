package com.swiss.trails.swisstrails_api;

import java.util.List;

import org.springframework.stereotype.Service;

import com.swiss.trails.swisstrails_api.dto.TrailRequest;
import com.swiss.trails.swisstrails_api.dto.TrailResponse;
import com.swiss.trails.swisstrails_api.entity.Trail;
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

    public TrailResponse createTrail(final TrailRequest trailRequest) {
        final Trail trail = new Trail();
        trail.setName(trailRequest.name());
        trail.setLengthKm(trailRequest.lengthKm());
        trail.setElevation(trailRequest.elevation());
        trail.setDifficulty(trailRequest.difficulty());
        final Trail savedTrail = trailRepository.save(trail);
        return toResponse(savedTrail);
    }


    private TrailResponse toResponse(final Trail trail) {
        return new TrailResponse(trail.getId(), trail.getName(), trail.getLengthKm(), trail.getElevation(), trail.getDifficulty());
    }
}
