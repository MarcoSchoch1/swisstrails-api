package com.swiss.trails.swisstrails_api.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "swisstrails")
public record TrailProperties(String maxDifficulty, int maxResults) {}