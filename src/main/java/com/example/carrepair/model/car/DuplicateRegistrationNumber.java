package com.example.carrepair.model.car;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
        value = HttpStatus.BAD_REQUEST,
        reason = "Car with the given registration number already exists"
)
public class DuplicateRegistrationNumber extends RuntimeException {
}
