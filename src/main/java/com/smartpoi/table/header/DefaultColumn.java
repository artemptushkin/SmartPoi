package com.smartpoi.table.header;

import lombok.EqualsAndHashCode;
import lombok.NonNull;

@EqualsAndHashCode(of = "value")
public class DefaultColumn<T> implements Column<T> {
    private final T value;

    public DefaultColumn(@NonNull T value) {
        this.value = value;
    }

    @Override
    public T getValue() {
        return value;
    }
}
