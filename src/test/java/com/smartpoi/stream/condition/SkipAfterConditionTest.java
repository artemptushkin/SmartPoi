package com.smartpoi.stream.condition;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SkipAfterConditionTest {
    SkipAfterCondition<Integer> skipAfterCondition;

    private Stream<Integer> ints = Stream.of(1, 2, 3, 4, 5, 6, 7);

    @Test
    void testCondition() {
        test(3, 5, 6, 7);
    }

    @Test
    void testConditionZero() {
        test(0, 2, 3, 4, 5, 6, 7);
    }

    @Test
    void testConditionMinus() {
        assertThrows(IllegalArgumentException.class,
                () -> test(-1, 2, 3, 4, 5, 6, 7));
    }

    private void test(int skip, Integer... contained) {
        skipAfterCondition = new SkipAfterCondition<>(v -> v == 2, skip);

        List<Integer> result = ints.filter(skipAfterCondition)
                .collect(Collectors.toList());

        assertThat(result, contains(contained));
    }

}