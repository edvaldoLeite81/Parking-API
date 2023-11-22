package com.okavango.parking_api.exceptions;

import java.io.Serial;

public class ResourceNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(Long id, String message) {
        super(message);
    }
}
