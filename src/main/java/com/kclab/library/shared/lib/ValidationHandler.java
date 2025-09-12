package com.kclab.library.shared.lib;

public interface ValidationHandler {
    void validate(ValidatorContext context);
    ValidationHandler next(ValidationHandler next);
}