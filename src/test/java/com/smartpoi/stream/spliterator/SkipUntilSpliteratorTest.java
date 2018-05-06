package com.smartpoi.stream.spliterator;

import com.smartpoi.stream.spliterator.SkipUntilSpliterator;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

class SkipUntilSpliteratorTest {

    @Test
    void skipUntilInclusive() {
        Stream<Integer> ints = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Stream<Integer> skipped = StreamSupport.stream(
                new SkipUntilSpliterator<>(
                        ints.spliterator(), v -> v == 5, true), false);

        List<Integer> collected = skipped.collect(Collectors.toList());

        assertThat(collected, Matchers.not(contains(1, 2, 3, 4, 5)));
        assertThat(collected, contains(6, 7, 8, 9, 10));
    }

    @Test
    void skipUntilNotInclusive() {
        Stream<Integer> ints = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Stream<Integer> skipped = StreamSupport.stream(
                new SkipUntilSpliterator<>(
                        ints.spliterator(), v -> v == 5, false), false);

        List<Integer> collected = skipped.collect(Collectors.toList());

        assertThat(collected, Matchers.not(contains(1, 2, 3, 4)));
        assertThat(collected, contains(5, 6, 7, 8, 9, 10));
    }
}