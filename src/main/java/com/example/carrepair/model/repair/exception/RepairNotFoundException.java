package com.example.carrepair.model.repair.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
        value = HttpStatus.BAD_REQUEST,
        reason = "Repair with the given Id number does not exists"
)
public class RepairNotFoundException extends RuntimeException{
}
