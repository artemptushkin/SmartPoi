package com.smartpoi.stream;

import java.util.Spliterator;
import java.util.function.Predicate;

public class BetweenSpliterator<T> extends AbstractBetweenSpliterator<T> {

    public BetweenSpliterator(Spliterator<T> source,
                              Predicate<T> leftCondition,
                              Predicate<T> rightCondition,
                              boolean inclusiveLeft, boolean inclusiveRight) {
        super(source, leftCondition, rightCondition, inclusiveLeft, inclusiveRight);
    }

    public BetweenSpliterator(Spliterator<T> source,
                              Predicate<T> leftCondition,
                              Predicate<T> rightCondition) {
        super(source, leftCondition, rightCondition);
    }

    @Override
    protected boolean shouldBeVisited(T value) {
        return isLeftRelative(value) && !isRightRelative(value);
    }
}
