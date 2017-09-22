/*
 * Task 01 - Containers
 * CSC Nsk Java 2017
 * Created by frikadelki on 2017/9/22
 */

package org.csc.nsk.java2017.task01;

import org.junit.rules.Timeout;

import java.util.Random;

final class TestUtils {
    private static final long DEFAULT_RANDOM_SEED = 456808;
    private static final long DEFAULT_TIMEOUT_MILLIS = 1000;

    static Random makeDefaultStableRandom() {
        return new Random(DEFAULT_RANDOM_SEED);
    }

    static Timeout makeDefaultTimeoutRule() {
        return Timeout.millis(DEFAULT_TIMEOUT_MILLIS);
    }

    private TestUtils() {
    }
}
