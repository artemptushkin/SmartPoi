package com.smartpoi.stream;

import java.util.Spliterator;
import java.util.function.Predicate;

public class TakeWhileSpliterator<T> extends AbstractBetweenSpliterator<T> {

    public TakeWhileSpliterator(Spliterator<T> source,
                                Predicate<T> condition) {
        super(source, condition, condition.negate(), true, false);
    }

    @Override
    protected boolean shouldBeVisited(T value) {
        return isLeftRelative(value) && !isRightRelative(value);
    }
}
