/*
 * Task 02 - Calculator
 * CSC Nsk Java 2017
 * Created by frikadelki on 2017/10/12
 */

package org.csc.nsk.java2017.task02;

import org.csc.nsk.java2017.utils.MathUtils;
import org.junit.Assert;
import org.junit.Test;

public final class CalculatorTests {
    @Test
    public void testOnePlusOne() {
        final Calculator calculator = CalculatorFactory.makeCalculator();
        Assert.assertEquals("One plus one should equal two.",
                2, calculator.calculate("1 1 +"), MathUtils.DEFAULT_DOUBLE_EQ_DELTA);
        Assert.assertEquals(-1, calculator.calculate("4 5 -"), MathUtils.DEFAULT_DOUBLE_EQ_DELTA);
    }
}
