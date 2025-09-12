package com.kclab.library.shared.lib;

public abstract class AbstractValidationHandler implements ValidationHandler {

    private ValidationHandler next;

    @Override
    public ValidationHandler next(ValidationHandler next) {
        this.next = next;
        return next;
    }

    protected void validateNext(ValidatorContext validatorContext) {
        if (next != null) {
            next.validate(validatorContext);
        }
    }
}