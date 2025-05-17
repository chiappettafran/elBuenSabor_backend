package org.internalPointerVariable.elbuensabor_backend.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(HttpServletRequest request, Exception ex) {
        HttpStatus status;
        if (ex instanceof NoSuchElementException || ex instanceof UsuarioNoEncontradoException) {
            status = HttpStatus.NOT_FOUND;
        } else if (ex instanceof ImageProcessingException || ex instanceof IllegalArgumentException) {
            status = HttpStatus.BAD_REQUEST;
        } else if (ex instanceof ClaveIncorrectaException) {
            status = HttpStatus.UNAUTHORIZED;
        } else {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        ErrorResponse error = new ErrorResponse(status, ex.getMessage(), request.getRequestURI());
        return new ResponseEntity<>(error, status);
    }
}
