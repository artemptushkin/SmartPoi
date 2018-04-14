package com.smartpoi.condition.column;

import com.smartpoi.table.header.Column;
import lombok.NonNull;

public class ColumnClassCondition implements ColumnCondition {

    private final Class clazz;

    public ColumnClassCondition(@NonNull Class clazz) {
        this.clazz = clazz;
    }

    @Override
    public boolean test(Column column) {
        return clazz.isInstance(column);
    }
}
