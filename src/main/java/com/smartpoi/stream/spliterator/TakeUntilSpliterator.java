package com.smartpoi.stream.spliterator;

import java.util.Spliterator;
import java.util.function.Predicate;

public class TakeUntilSpliterator<T> extends AbstractBetweenSpliterator<T> {

    public TakeUntilSpliterator(Spliterator<T> source,
                                Predicate<T> condition,
                                boolean inclusive) {
        super(source, t -> true, condition, true, inclusive);
    }

    @Override
    protected boolean shouldBeVisited(T value) {
        return !isRightRelative(value);
    }
}
