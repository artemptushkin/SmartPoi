package com.smartpoi.stream.condition;

import java.util.function.Predicate;

/* Current Predicate<T> class returns true when has found @param wrappedCondition
 * and passed 'n' elements = @param skip
 *
 * Otherwise returns false
 *
 * For the correct result use only current object for the single stream run
 * and do not reuse at the another stream.
 *
 * Skip value should be >= 0 otherwise - IllegalArgumentException
 */
public class SkipAfterCondition<T> implements Predicate<T> {

    private final Predicate<T> wrappedCondition;
    private final int skip;

    private boolean foundCondition = false;
    private int passed = 0;

    public SkipAfterCondition(Predicate<T> wrappedCondition, int skip) {
        if (skip < 0 ) throw new IllegalArgumentException("Skip value should be >= 0");
        this.wrappedCondition = wrappedCondition;
        this.skip = skip;
    }

    @Override
    public boolean test(T value) {
        if (foundCondition) {
            incrementPassedIfNecessary();
            return passed == skip;
        } else {
            foundCondition = wrappedCondition.test(value);
            return foundCondition && passed == skip;
        }
    }

    private void incrementPassedIfNecessary() {
        if (passed < skip) {
            ++passed;
        }
    }
}
