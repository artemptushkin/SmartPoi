package com.smartpoi.visitors;

import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.StreamSupport;

public abstract class LazyVisitor<FROM extends Iterable<WHAT>, WHAT> implements SpliteratorVisitor<FROM, WHAT> {
    private final Consumer<WHAT> visitor;

    protected LazyVisitor(Consumer<WHAT> visitor) {
        this.visitor = visitor;
    }

    @Override
    public void accept(FROM from) {
        Spliterator<WHAT> spliterator = buildSpliterator(from.spliterator());
        StreamSupport.stream(spliterator, false)
                .forEach(visitor);
    }
}
