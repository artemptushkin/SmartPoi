package com.smartpoi.visitors;

import com.smartpoi.stream.spliterator.SpliteratorBuilder;

import java.util.function.Consumer;

interface SpliteratorVisitor<FROM extends Iterable<WHAT>, WHAT> extends Consumer<FROM>, SpliteratorBuilder<WHAT> {
}
