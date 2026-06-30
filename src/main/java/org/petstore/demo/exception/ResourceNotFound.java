package org.petstore.demo.exception;

public class ResourceNotFound extends ApiException {
    public ResourceNotFound(String message) {
        super(message);
    }
}
