package com.smartpoi.stream;

import lombok.AccessLevel;
import lombok.Getter;

import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;

public abstract class AbstractBetweenSpliterator<T> implements Spliterator<T> {
    private final Spliterator<T> source;
    @Getter(value = AccessLevel.PROTECTED)
    private final Predicate<T> leftCondition;
    @Getter(value = AccessLevel.PROTECTED)
    private final Predicate<T> rightCondition;

    private final boolean inclusiveLeft;
    private final boolean inclusiveRight;

    private boolean leftFound;
    private boolean rightFound;

    protected AbstractBetweenSpliterator(Spliterator<T> source,
                                         Predicate<T> leftCondition,
                                         Predicate<T> rightCondition,
                                         boolean inclusiveLeft,
                                         boolean inclusiveRight) {
        this.source = source;
        this.leftCondition = leftCondition;
        this.rightCondition = rightCondition;
        this.inclusiveLeft = inclusiveLeft;
        this.inclusiveRight = inclusiveRight;
    }

    protected AbstractBetweenSpliterator(Spliterator<T> source,
                                         Predicate<T> leftCondition,
                                         Predicate<T> rightCondition) {
        this.source = source;
        this.leftCondition = leftCondition;
        this.rightCondition = rightCondition;
        this.inclusiveLeft = false;
        this.inclusiveRight = false;
    }

    @Override
    public boolean tryAdvance(Consumer<? super T> action) {
        return source.tryAdvance(t -> {
            if (shouldBeVisited(t)) {
                action.accept(t);
            }
        });
    }

    @Override
    public Spliterator<T> trySplit() {
        return null;
    }

    @Override
    public long estimateSize() {
        return source.estimateSize();
    }

    /* Часть характеристик наследуется у исходного сплитератора, но необходимо сбросить NONNULL,
    * DISTINCT и SORTED: мы не можем гарантировать этих характеристик после применения произвольной mapper-функции
    */
    @Override
    public int characteristics() {
        return source.characteristics() & (SIZED | SUBSIZED | CONCURRENT | IMMUTABLE | ORDERED);
    }

    boolean isLeftRelative(T value) {
        if (leftFound) {
            return true;
        } else if (testLeft(value)) {
            leftFound = true;
            return inclusiveLeft;
        } else {
            return false;
        }
    }

    boolean isRightRelative(T value) {
        if (rightFound) {
            return true;
        } else if (testRight(value)) {
            rightFound = true;
            return !inclusiveRight;
        } else {
            return false;
        }
    }

    private boolean testLeft(T value) {
        return leftCondition.test(value);
    }

    private boolean testRight(T value) {
        return rightCondition.test(value);
    }

    protected abstract boolean shouldBeVisited(T value);
}
