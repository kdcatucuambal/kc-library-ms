package com.kclab.library.shared.lib;

import lombok.RequiredArgsConstructor;

import java.util.List;


public class ValidatorExecutor {


    /**
     * Chain of Responsibility Pattern to validate the input context with multiple validators.
     * @param context the context to be validated, it will be modified by the validators
     * @param validators the validators to be applied in order to the context
     * @return the modified context after all validators have been applied
     */
    public static ValidatorContext validate(ValidatorContext context, ValidationHandler... validators) {
        var handlers = List.of(validators);
        for (int i = 0; i < handlers.size() - 1; i++) {
            handlers.get(i).next(handlers.get(i + 1));
        }
        handlers.get(0).validate(context);
        return context;
    }


}
