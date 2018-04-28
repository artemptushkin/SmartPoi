package com.smartpoi.stream.spliterator;

import java.util.Spliterator;
import java.util.function.Predicate;

public class SkipUntilSpliterator<T> extends AbstractBetweenSpliterator<T> {

    public SkipUntilSpliterator(Spliterator<T> source,
                                Predicate<T> condition,
                                boolean inclusive) {
        super(source, t -> true, condition, true, inclusive);
    }

    @Override
    protected boolean shouldBeVisited(T value) {
        return isRightRelative(value);
    }
}
