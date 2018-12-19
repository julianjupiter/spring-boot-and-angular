package io.github.julianjupiter.springbootandangular.server.exception;

public class ResourceNotFoundException extends ApiException {
    public ResourceNotFoundException(String message, String path) {
        super(message, path);
    }
}
