package com.smartpoi.visitors;

import com.smartpoi.stream.spliterator.BetweenSpliterator;

import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ExcelBetweenVisitor<FROM extends Iterable<WHAT>, WHAT> extends LazyVisitor<FROM, WHAT> {

    private final Predicate<WHAT> leftCondition;
    private final Predicate<WHAT> rightCondition;
    private final Boolean inclusiveLeft;
    private final Boolean inclusiveRight;

    public ExcelBetweenVisitor(Consumer<WHAT> visitor,
                               Predicate<WHAT> leftCondition,
                               Predicate<WHAT> rightCondition,
                               boolean inclusiveLeft,
                               boolean inclusiveRight) {
        super(visitor);
        this.leftCondition = leftCondition;
        this.rightCondition = rightCondition;
        this.inclusiveLeft = inclusiveLeft;
        this.inclusiveRight = inclusiveRight;
    }

    public ExcelBetweenVisitor(Consumer<WHAT> cellVisitor,
                               Predicate<WHAT> leftCondition,
                               Predicate<WHAT> rightCondition) {
        super(cellVisitor);
        this.leftCondition = leftCondition;
        this.rightCondition = rightCondition;
        this.inclusiveLeft = null;
        this.inclusiveRight = null;
    }

    @Override
    public BetweenSpliterator<WHAT> buildSpliterator(Spliterator<WHAT> source) {
        if (inclusiveLeft == null || inclusiveRight == null) {
            return new BetweenSpliterator<>(source, leftCondition, rightCondition);
        }
        return new BetweenSpliterator<>(source, leftCondition, rightCondition, inclusiveLeft, inclusiveRight);
    }

}
