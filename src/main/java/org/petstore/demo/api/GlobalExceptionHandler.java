package org.petstore.demo.api;

import lombok.extern.slf4j.Slf4j;
import org.petstore.demo.exception.ApiException;
import org.petstore.demo.exception.BadGateway;
import org.petstore.demo.exception.ResourceNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    // Capture standard Bean Validation constraints (@NotNull, @Size, etc.)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handle(MethodArgumentNotValidException ex) {
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(
                HttpStatus.BAD_REQUEST, "Validation failed"
        );

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );

        // Extend properties dictionary safely
        problem.setProperty("invalid_fields", errors);
        return problem;
    }

    @ExceptionHandler(ResourceNotFound.class)
    public ProblemDetail handle(ResourceNotFound ex) {
        log.warn("handle ResourceNotFound", ex);
        return ProblemDetail.forStatusAndDetail(
                HttpStatus.NOT_FOUND, ex.getMessage()
        );
    }

    @ExceptionHandler(BadGateway.class)
    public ProblemDetail handle(BadGateway ex) {
        log.error("handle BadGateway", ex);
        return ProblemDetail.forStatusAndDetail(
                HttpStatus.BAD_GATEWAY, ex.getMessage()
        );
    }

    @ExceptionHandler(ApiException.class)
    public ProblemDetail handle(ApiException ex) {
        log.error("handle ApiException", ex);
        return ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(RuntimeException.class)
    public ProblemDetail handle(RuntimeException ex) {
        log.error("handle RuntimeException", ex);
        return ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
