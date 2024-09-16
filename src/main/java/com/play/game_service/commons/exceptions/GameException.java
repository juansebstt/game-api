package com.play.game_service.commons.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

// Custom exception class for game-related errors
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GameException extends RuntimeException{

    private HttpStatus httpStatus; // Holds the HTTP status for the error

    // Constructor with status and message for the exception
    public GameException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
