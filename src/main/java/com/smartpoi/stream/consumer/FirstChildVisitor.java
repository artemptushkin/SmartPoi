package com.smartpoi.stream.consumer;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;

import java.util.Optional;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.StreamSupport;

public abstract class FirstChildVisitor<Parent extends Iterable<Child>, Child> extends ChildrenVisitor<Parent, Child> {

    @Getter(AccessLevel.PROTECTED)
    private final Predicate<Child> condition;

    public FirstChildVisitor(@NonNull Consumer<Child> childrenConsumer,
                             Predicate<Child> condition) {
        super(childrenConsumer);
        this.condition = condition;
    }

    @Override
    public Spliterator<Child> buildSpliterator(Spliterator<Child> source) {
        return source;
    }

    @Override
    public void accept(Parent parent) {
        Optional<Child> childOptional = StreamSupport.stream(parent.spliterator(), false)
                .filter(condition)
                .findFirst();
        Child child = orElseCustom(parent, childOptional);
        childrenConsumer.accept(child);
    }

    protected abstract Child orElseCustom(Parent parent, Optional<Child> childOptional);
}
