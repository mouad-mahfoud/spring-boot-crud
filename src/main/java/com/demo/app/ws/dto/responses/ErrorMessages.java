package com.demo.app.ws.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorMessages {
    MISSING_REQUIRED_FIELLD("Missing required field."),
    RECORD_ALREDY_EXISTS("Record alredy exists."),
    INTERNAL_SERVER_ERROR("Internal server error."),
    NO_RECORD_FOUND("Record with provided id not found.");


    private String errorMessage;
}
