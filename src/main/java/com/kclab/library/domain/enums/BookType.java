package com.kclab.library.domain.enums;

import lombok.Getter;

@Getter
public enum BookType {

    FICTION("FICTION"),
    NON_FICTION("NON-FICTION");

    private final String value;

    BookType(String value) {
        this.value = value;
    }

    public static BookType fromValue(String value) {
        for (BookType type : BookType.values()) {
            if (type.getValue().equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown book status: " + value);
    }

}
