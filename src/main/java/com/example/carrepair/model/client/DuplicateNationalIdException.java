package com.example.carrepair.model.client;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
        value = HttpStatus.BAD_REQUEST,
        reason = "Client with the given National Id number already exists"
)
public class DuplicateNationalIdException extends RuntimeException {
}
