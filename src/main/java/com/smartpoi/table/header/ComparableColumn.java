package com.smartpoi.table.header;

import lombok.EqualsAndHashCode;
import lombok.NonNull;

@EqualsAndHashCode(callSuper = true)
public class ComparableColumn<T extends Comparable> extends DefaultColumn<T> implements Comparable<T> {

    public ComparableColumn(@NonNull T value) {
        super(value);
    }

    @Override
    public int compareTo(@NonNull T other) {
        return getValue().compareTo(other);
    }
}
