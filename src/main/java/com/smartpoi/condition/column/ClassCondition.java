package com.smartpoi.condition.column;

import lombok.NonNull;

import java.util.function.Predicate;

public class ClassCondition<C> implements Predicate<C> {

    private final Class clazz;

    public ClassCondition(@NonNull Class clazz) {
        this.clazz = clazz;
    }

    @Override
    public boolean test(C column) {
        return clazz.isInstance(column);
    }
}
