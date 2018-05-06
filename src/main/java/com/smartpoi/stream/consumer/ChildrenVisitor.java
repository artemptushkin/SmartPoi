package com.smartpoi.stream.consumer;

import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public abstract class ChildrenVisitor<Parent extends Iterable<Child>, Child> implements SpliteratorVisitor<Parent, Child> {
    protected final Consumer<Child> childrenConsumer;

    protected ChildrenVisitor(Consumer<Child> childrenConsumer) {
        this.childrenConsumer = childrenConsumer;
    }

    protected Stream<Child> fromSpliterator(Spliterator<Child> spliterator) {
        return StreamSupport.stream(spliterator, false);
    }

    protected Stream<Child> fromSpliterator(Spliterator<Child> spliterator, boolean parallel) {
        return StreamSupport.stream(spliterator, parallel);
    }
}
