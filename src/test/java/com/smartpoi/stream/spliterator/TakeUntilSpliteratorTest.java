package com.smartpoi.stream.spliterator;

import com.smartpoi.stream.spliterator.TakeUntilSpliterator;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

class TakeUntilSpliteratorTest {

    @Test
    void takeUntilInclusive() {
        Stream<Integer> ints = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Stream<Integer> skipped = StreamSupport.stream(
                new TakeUntilSpliterator<>(
                        ints.spliterator(), v -> v == 5, true), false);

        List<Integer> collected = skipped.collect(Collectors.toList());

        assertThat(collected, Matchers.not(contains(6, 7, 8, 9, 10)));
        assertThat(collected, contains(1, 2, 3, 4, 5));
    }

    @Test
    void takeUntilNotInclusive() {
        Stream<Integer> ints = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Stream<Integer> skipped = StreamSupport.stream(
                new TakeUntilSpliterator<>(
                        ints.spliterator(), v -> v == 5, false), false);

        List<Integer> collected = skipped.collect(Collectors.toList());

        assertThat(collected, Matchers.not(contains(5, 6, 7, 8, 9, 10)));
        assertThat(collected, contains(1, 2, 3, 4));
    }

}