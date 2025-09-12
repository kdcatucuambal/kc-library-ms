package com.kclab.library.shared.lib;

import java.util.HashMap;
import java.util.Map;

public class ValidatorContext {

    private final Map<String, Object> context;

    private ValidatorContext(Map<String, Object> context) {
        this.context = context;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final Map<String, Object> context = new HashMap<>();

        public Builder add(String key, Object value) {
            context.put(key, value);
            return this;
        }

        public ValidatorContext build() {
            return new ValidatorContext(context);
        }
    }

    public void add(String key, Object value) {
        context.put(key, value);
    }

    public Object get(String key) {
        return context.get(key);
    }

    public String getString(String key) {
        return (String) context.get(key);
    }

    public Long getLong(String key) {
        return (Long) context.get(key);
    }

    public Double getDouble(String key) {
        return (Double) context.get(key);
    }

    public Boolean getBoolean(String key) {
        return (Boolean) context.get(key);
    }

    public Integer getInteger(String key) {
        return (Integer) context.get(key);
    }

    public <T> T getValue(String key, Class<T> type) {
        Object value = context.get(key);
        if (value == null) {
            return null;
        }
        if (type.isInstance(value)) {
            return type.cast(value);
        } else {
            throw new ClassCastException("Value for key '" + key + "' is not of type " + type.getName());
        }
    }
}

