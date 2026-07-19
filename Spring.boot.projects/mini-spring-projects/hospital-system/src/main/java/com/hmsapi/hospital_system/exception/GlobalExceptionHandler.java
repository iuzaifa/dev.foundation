package com.hmsapi.hospital_system.exception;

import com.hmsapi.hospital_system.dto.ExceptionResponseDTO;
import com.hmsapi.hospital_system.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<ExceptionResponseDTO> handleAlreadyExistsException(
            AlreadyExistsException exception, WebRequest webRequest) {
        ExceptionResponseDTO response = new ExceptionResponseDTO(
                webRequest.getDescription(false),
                HttpStatus.CONFLICT.toString(),
                exception.getMessage(),
                LocalDateTime.now().toString()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }


    @ExceptionHandler(NotExistsException.class)
    public ResponseEntity<ExceptionResponseDTO> handleNotExistsException(
            NotExistsException exception, WebRequest webRequest) {
        ExceptionResponseDTO response = new ExceptionResponseDTO(
                webRequest.getDescription(false),
                HttpStatus.CONFLICT.toString(),
                exception.getMessage(),
                LocalDateTime.now().toString()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponseDTO> handleValidationException(MethodArgumentNotValidException ex, WebRequest request) {
        String errorMessage = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.joining(", "));

        ExceptionResponseDTO response = new ExceptionResponseDTO(
                request.getDescription(false),
                HttpStatus.BAD_REQUEST.toString(),
                errorMessage,
                LocalDateTime.now().toString()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
