package com.okavango.parking_api.exceptions;

import java.io.Serial;

public class DatabaseException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public DatabaseException(Long id, String message) {
        super(message);
    }
}
