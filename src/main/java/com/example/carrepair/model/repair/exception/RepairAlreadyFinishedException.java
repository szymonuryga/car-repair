package com.example.carrepair.model.repair.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
        value = HttpStatus.BAD_REQUEST,
        reason = "Reapir with the given Id number already exists"
)
public class RepairAlreadyFinishedException extends RuntimeException {
}
