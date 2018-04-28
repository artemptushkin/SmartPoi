package com.smartpoi.stream.spliterator;

import java.util.Spliterator;

public interface SpliteratorBuilder<T> {
    Spliterator<T> buildSpliterator(Spliterator<T> source);
}
