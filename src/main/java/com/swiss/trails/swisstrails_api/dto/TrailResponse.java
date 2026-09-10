package com.swiss.trails.swisstrails_api.dto;

import java.util.List;

public record TrailResponse(Long id, String name, Double lengthKm, Integer elevation, String difficulty, List<String> checkpointNames) {}

