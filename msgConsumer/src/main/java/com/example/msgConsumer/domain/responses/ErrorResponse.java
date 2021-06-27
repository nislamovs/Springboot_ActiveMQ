package com.example.msgConsumer.domain.responses;

import static java.lang.String.format;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {

    public String errorText;

    public ErrorResponse(String format, Object... args) {
        this(format(format, args));
    }
}


