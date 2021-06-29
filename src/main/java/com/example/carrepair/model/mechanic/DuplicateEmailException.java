package com.example.carrepair.model.mechanic;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
        value = HttpStatus.BAD_REQUEST,
        reason = "Mechanic with the given Email already exists"
)
public class DuplicateEmailException extends RuntimeException {
}
