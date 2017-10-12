/*
 * Utilities Library
 * CSC Nsk Java 2017
 * Created by frikadelki on 2017/10/11
 */

package org.csc.nsk.java2017.utils;

import org.junit.Assert;
import org.junit.Test;

public final class MathUtilsTests {
    @Test
    public void testDoubleIsFinite() {
        Assert.assertTrue("0 should be finite", MathUtils.isFinite(0));
        Assert.assertTrue("244 should be finite", MathUtils.isFinite(244));
        Assert.assertTrue("Max value should be finite", MathUtils.isFinite(Double.MAX_VALUE));
        Assert.assertTrue("Min value should be finite", MathUtils.isFinite(Double.MIN_VALUE));
        Assert.assertFalse("NaN should not be finite", MathUtils.isFinite(Double.NaN));
        Assert.assertFalse("Positive infinity should not be finite", MathUtils.isFinite(Double.POSITIVE_INFINITY));
        Assert.assertFalse("Negative infinity should not be finite", MathUtils.isFinite(Double.NEGATIVE_INFINITY));
    }
}
