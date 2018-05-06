package com.smartpoi.stream.spliterator;

import com.smartpoi.stream.spliterator.TakeWhileSpliterator;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

class TakeWhileSpliteratorTest {
    @Test
    void skipUntilInclusive() {
        Stream<Integer> ints = Stream.of(2, 4, 6, 1, 3, 5, 7, 8, 9, 10);
        Stream<Integer> skipped = StreamSupport.stream(
                new TakeWhileSpliterator<>(
                        ints.spliterator(), v -> v % 2 == 0), false);

        List<Integer> collected = skipped.collect(Collectors.toList());

        assertThat(collected, Matchers.not(contains(1, 3, 5, 7, 9, 8, 10)));
        assertThat(collected, contains(2, 4, 6));
    }
}