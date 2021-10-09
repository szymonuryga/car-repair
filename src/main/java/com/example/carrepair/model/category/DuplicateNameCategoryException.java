package com.example.carrepair.model.category;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
        value = HttpStatus.BAD_REQUEST,
        reason = "Category with the given name already exists"
)
public class DuplicateNameCategoryException extends RuntimeException {
}
