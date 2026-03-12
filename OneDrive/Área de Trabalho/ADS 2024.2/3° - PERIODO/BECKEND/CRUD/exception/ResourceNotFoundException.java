package com.example.marketplace.exception;

/**
 * Exceção personalizada para recurso não encontrado.
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}