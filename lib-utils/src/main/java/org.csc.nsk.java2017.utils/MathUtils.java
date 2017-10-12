/*
 * Utilities Library
 * CSC Nsk Java 2017
 * Created by frikadelki on 2017/10/11
 */

package org.csc.nsk.java2017.utils;

public final class MathUtils {
    public static final double DEFAULT_DOUBLE_EQ_DELTA = 10e-8;

    public static boolean isFinite(final double val) {
        return (Double.MAX_VALUE >= Math.abs(val));
    }

    private MathUtils() {
    }
}
