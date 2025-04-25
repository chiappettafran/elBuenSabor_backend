package org.internalPointerVariable.elbuensabor_backend.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(HttpServletRequest request, Exception ex) {
        HttpStatus status;
        if (ex instanceof NoSuchElementException) {
            status = HttpStatus.NOT_FOUND;
        } else if (ex instanceof ImageProcessingException) {
            status = HttpStatus.BAD_REQUEST;
        } else {
            status = HttpStatus.BAD_REQUEST;
        }

        ErrorResponse error = new ErrorResponse(status, ex.getMessage(), request.getRequestURI());
        return new ResponseEntity<>(error, status);
    }
}
