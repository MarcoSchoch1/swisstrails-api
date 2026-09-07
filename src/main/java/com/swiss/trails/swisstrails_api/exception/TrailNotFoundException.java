package com.swiss.trails.swisstrails_api.exception;

public class TrailNotFoundException extends RuntimeException {
    public TrailNotFoundException(Long id) { super("Trail " + id + " not found"); }
    public TrailNotFoundException(String name) { super("Trail " + name + " not found"); }
}
