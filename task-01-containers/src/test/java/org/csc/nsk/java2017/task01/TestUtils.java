/*
 * Task 01 - Containers
 * CSC Nsk Java 2017
 * Created by frikadelki on 2017/9/22
 */

package org.csc.nsk.java2017.task01;

import java.util.Random;

final class TestUtils {
    private static final long DEFAULT_SEED = 456808;

    static Random makeDefaultStableRandom() {
        return new Random(DEFAULT_SEED);
    }

    private TestUtils() {
    }
}
