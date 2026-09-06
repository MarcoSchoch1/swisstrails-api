package com.swiss.trails.swisstrails_api.exception;

public class TrailNotFoundException extends RuntimeException {
    public TrailNotFoundException(Long id) { super("Trail " + id + " not found"); }
}
