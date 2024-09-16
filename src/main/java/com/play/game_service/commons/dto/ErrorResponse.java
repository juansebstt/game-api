package com.play.game_service.commons.dto;

import lombok.*;

// Data transfer object for sending error details in responses
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    private Integer codeStatus; // HTTP status code
    private String message; // Error message
}
