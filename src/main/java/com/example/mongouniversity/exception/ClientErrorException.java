package com.example.mongouniversity.exception;

import lombok.Getter;

import java.time.Instant;

@Getter
public abstract class ClientErrorException extends RuntimeException {
    protected Instant date = Instant.now();

    public ClientErrorException(String message, Object...args) {
        super(String.format(message, args));
    }

    public static class BadRequestException extends ClientErrorException {
        public BadRequestException(String message, Object... args) {
            super(message, args);
        }
    }

    public static class NotFoundException extends ClientErrorException {
        public NotFoundException(String message, Object... args) {
            super(message, args);
        }
    }

    public static class InvalidInputException extends ClientErrorException {
        public InvalidInputException(String message, Object... args) {
            super(message, args);
        }
    }
}
