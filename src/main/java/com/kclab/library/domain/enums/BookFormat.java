package com.kclab.library.domain.enums;

import lombok.Getter;

@Getter
public enum BookFormat {

    DIGITAL("Digital"),
    PRINT("Print");

    private final String value;

    BookFormat(String value) {
        this.value = value;
    }

    public static BookFormat fromValue(String value) {
        for (BookFormat format : BookFormat.values()) {
            if (format.getValue().equalsIgnoreCase(value)) {
                return format;
            }
        }
        throw new IllegalArgumentException("Unknown book format: " + value);
    }


}
