package com.swiss.trails.swisstrails_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.groups.Default;

/**
 * TrailRequest
 */
public record TrailRequest(@NotBlank(groups = TrailRequest.OnCreate.class) String name, @Positive Double lengthKm, Integer elevation, @Pattern (regexp = "easy|moderate|difficult") String difficulty) {

    // Validation group for creation: name is required on POST, but not on PUT
    // where fields left out of the body should simply be left unchanged.
    public interface OnCreate extends Default {}
}
