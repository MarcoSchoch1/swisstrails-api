package com.swiss.trails.swisstrails_api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.swiss.trails.swisstrails_api.dto.TrailRequest;
import com.swiss.trails.swisstrails_api.dto.TrailResponse;
import com.swiss.trails.swisstrails_api.entity.Trail;
import com.swiss.trails.swisstrails_api.repository.TrailRepository;
import com.swiss.trails.swisstrails_api.service.TrailService;

@ExtendWith (MockitoExtension.class)
public class TrailServiceTest {
    
    @Mock TrailRepository repository;
    @InjectMocks TrailService service;

    @Test
    void createsATrail() {
        when(repository.save(any())).thenReturn(new Trail(1L, "Fünf-Seen-Wanderung", 12.0, 500, "moderate", new ArrayList<>()));
        TrailResponse result = service.createOrUpdateTrail(null, new TrailRequest("Fünf-Seen-Wanderung", 12.0, 500, "moderate"));
        assertThat(result.name()).isEqualTo("Fünf-Seen-Wanderung");
    }
}
