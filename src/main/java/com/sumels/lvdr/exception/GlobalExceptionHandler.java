package com.sumels.lvdr.exception;

import com.sumels.lvdr.dto.ApiMessageDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ApiMessageDto<Void>> handleNotFoundException(NotFoundException ex) {
        return buildErrorResponse(false, null, ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ApiMessageDto<Void>> handleGenericException(Exception ex) {
        return buildErrorResponse(false, null, "An unexpected error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<ApiMessageDto<Void>> buildErrorResponse(boolean result, String code, String message, HttpStatus status) {
        ApiMessageDto<Void> response = new ApiMessageDto<>();
        response.setResult(result);
        response.setCode(code);
        response.setMessage(message);
        return new ResponseEntity<>(response, status);
    }
}
