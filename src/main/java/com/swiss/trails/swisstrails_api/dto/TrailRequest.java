package com.swiss.trails.swisstrails_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

/**
 * TrailRequest
 */
public record TrailRequest(@NotBlank String name, @Positive double lengthKm, int elevation, @Pattern (regexp = "easy|moderate|difficult") String difficulty) {}
