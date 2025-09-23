package com.kclab.library.domain.enums;

import lombok.Getter;

@Getter
public enum BookStatus {

    AVAILABLE("AVAILABLE"),
    LOANED("LOANED");

    private final String value;

    BookStatus(String value) {
        this.value = value;
    }

    public static BookStatus fromValue(String value) {
        for (BookStatus status : BookStatus.values()) {
            if (status.getValue().equalsIgnoreCase(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown book status: " + value);
    }

}
