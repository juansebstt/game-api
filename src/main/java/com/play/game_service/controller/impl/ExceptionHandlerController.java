package com.play.game_service.controller.impl;

import com.play.game_service.commons.dto.ErrorResponse;
import com.play.game_service.commons.exceptions.GameException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// Global exception handler to catch and handle custom exceptions (GameException)
@RestControllerAdvice
@Slf4j // Lombok annotation for logging
public class ExceptionHandlerController {
    @ExceptionHandler(value = {GameException.class}) // Handles GameException
    ResponseEntity<ErrorResponse> handleError(GameException gameException){
        log.error("New Exception", gameException); // Log the exception details
        var errorResponse = ErrorResponse.builder()
                .codeStatus(gameException.getHttpStatus().value()) // Set HTTP status code in the response
                .message(gameException.getMessage()) // Set the error message in the response
                .build();

        return ResponseEntity.status(gameException.getHttpStatus()).body(errorResponse); // Return the error response
    }
}
