package com.smartpoi.visitors;

import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public abstract class ChildVisitor<Parent extends Iterable<Child>, Child> implements SpliteratorVisitor<Parent, Child> {
    protected final Consumer<Child> visitor;

    protected ChildVisitor(Consumer<Child> visitor) {
        this.visitor = visitor;
    }

    protected Stream<Child> fromSpliterator(Spliterator<Child> spliterator) {
        return StreamSupport.stream(spliterator, false);
    }

    protected Stream<Child> fromSpliterator(Spliterator<Child> spliterator, boolean parallel) {
        return StreamSupport.stream(spliterator, parallel);
    }
}
