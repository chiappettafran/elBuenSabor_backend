package org.internalPointerVariable.elbuensabor_backend.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.internalPointerVariable.elbuensabor_backend.exceptions.ErrorResponse;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(HttpServletRequest request, Exception ex) {
        HttpStatus status = ex instanceof NoSuchElementException
                ? HttpStatus.NOT_FOUND
                : HttpStatus.BAD_REQUEST;
        ErrorResponse error = new ErrorResponse(status, ex.getMessage(), request.getRequestURI());
        return new ResponseEntity<>(error, status);
    }
}
