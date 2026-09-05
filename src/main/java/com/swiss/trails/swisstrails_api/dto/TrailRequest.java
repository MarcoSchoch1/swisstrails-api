package com.swiss.trails.swisstrails_api.dto;

/**
 * TrailRequest
 */
public record TrailRequest(String name, double lengthKm, int elevation, String difficulty) {}
