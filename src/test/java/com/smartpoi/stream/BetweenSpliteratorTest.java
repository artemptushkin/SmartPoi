package com.smartpoi.stream;

import com.smartpoi.stream.spliterator.BetweenSpliterator;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

class BetweenSpliteratorTest {

    @Test
    void betweenTestInclusiveLeft() {
        Stream<Integer> ints = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Stream<Integer> skipped = StreamSupport.stream(
                new BetweenSpliterator<>(
                        ints.spliterator(), v -> v == 2, v -> v == 9, true, false), false);

        List<Integer> collected = skipped.collect(Collectors.toList());

        assertThat(collected, Matchers.not(contains(1, 9, 10)));
        assertThat(collected, contains(2, 3, 4, 5, 6, 7, 8));
    }

    @Test
    void betweenTestInclusiveRight() {
        Stream<Integer> ints = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Stream<Integer> skipped = StreamSupport.stream(
                new BetweenSpliterator<>(
                        ints.spliterator(), v -> v == 2, v -> v == 9, false, true), false);

        List<Integer> collected = skipped.collect(Collectors.toList());

        assertThat(collected, Matchers.not(contains(1, 10)));
        assertThat(collected, contains(3, 4, 5, 6, 7, 8, 9));
    }

    @Test
    void betweenTestInclusiveLeftRight() {
        Stream<Integer> ints = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Stream<Integer> skipped = StreamSupport.stream(
                new BetweenSpliterator<>(
                        ints.spliterator(), v -> v == 2, v -> v == 9, true, true), false);

        List<Integer> collected = skipped.collect(Collectors.toList());

        assertThat(collected, Matchers.not(contains(1, 10)));
        assertThat(collected, contains(2, 3, 4, 5, 6, 7, 8, 9));
    }

    @Test
    void betweenTestNotInclusive() {
        Stream<Integer> ints = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Stream<Integer> skipped = StreamSupport.stream(
                new BetweenSpliterator<>(
                        ints.spliterator(), v -> v == 2, v -> v == 9), false);

        List<Integer> collected = skipped.collect(Collectors.toList());

        assertThat(collected, Matchers.not(contains(1, 10)));
        assertThat(collected, contains(3, 4, 5, 6, 7, 8));
    }

}