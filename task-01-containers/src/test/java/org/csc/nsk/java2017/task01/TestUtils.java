/*
 * Task 01 - Containers
 * CSC Nsk Java 2017
 * Created by frikadelki on 2017/9/22
 */

package org.csc.nsk.java2017.task01;

import org.junit.rules.Timeout;

import java.util.function.Function;

final class TestUtils {
    public interface Random {
        Integer nextInteger();

        default <TMapped> TMapped mapNextInteger(final Function<Integer, TMapped> mapper) {
            if (mapper == null) {
                throw new IllegalArgumentException();
            }
            return mapper.apply(nextInteger());
        }
    }

    private static final long DEFAULT_RANDOM_SEED = 456808;

    static Random makeDefaultStableRandom() {
        return new NiceRandom(DEFAULT_RANDOM_SEED);
    }

    private static final long DEFAULT_TIMEOUT_MILLIS = 1000;

    static Timeout makeDefaultTimeoutRule() {
        return Timeout.millis(DEFAULT_TIMEOUT_MILLIS);
    }

    private static class NiceRandom implements Random {
        private final java.util.Random innerRandom;

        NiceRandom(final long seed) {
            innerRandom = new java.util.Random(seed);
        }

        @Override
        public Integer nextInteger() {
            return innerRandom.nextInt();
        }
    }

    private TestUtils() {
    }
}
