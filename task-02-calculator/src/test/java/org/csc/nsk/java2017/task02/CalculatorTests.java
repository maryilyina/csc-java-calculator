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
    private final Calculator calculator = CalculatorFactory.makeCalculator();

    @Test
    public void DoubleRepresentationTest() {
        Assert.assertEquals(2, calculator.calculate("1 + 1"), MathUtils.DEFAULT_DOUBLE_EQ_DELTA);
        Assert.assertEquals(2, calculator.calculate("1+1"), MathUtils.DEFAULT_DOUBLE_EQ_DELTA);
        Assert.assertEquals(2, calculator.calculate("1.0+1"), MathUtils.DEFAULT_DOUBLE_EQ_DELTA);
        Assert.assertEquals(1.11e-11, calculator.calculate("1.11e-11"), MathUtils.DEFAULT_DOUBLE_EQ_DELTA);
    }

    @Test
    public void OperatorsPriorityTest() {
        Assert.assertEquals(7, calculator.calculate("1 + 2 * 3"), MathUtils.DEFAULT_DOUBLE_EQ_DELTA);
        Assert.assertEquals(7, calculator.calculate("2 * 3 + 1"), MathUtils.DEFAULT_DOUBLE_EQ_DELTA);
        Assert.assertEquals(6 + Math.cos(45), calculator.calculate("2 * 3 + cos 45"), MathUtils.DEFAULT_DOUBLE_EQ_DELTA);
    }

    @Test
    public void CalculatorOperatorsTest() {
        Assert.assertEquals(10, calculator.calculate("6+4"), MathUtils.DEFAULT_DOUBLE_EQ_DELTA);
        Assert.assertEquals(2, calculator.calculate("6-4"), MathUtils.DEFAULT_DOUBLE_EQ_DELTA);
        Assert.assertEquals(12, calculator.calculate("6*2"), MathUtils.DEFAULT_DOUBLE_EQ_DELTA);
        Assert.assertEquals(6.5 / 31, calculator.calculate("6.5 / 31"), MathUtils.DEFAULT_DOUBLE_EQ_DELTA);
        Assert.assertEquals(216, calculator.calculate("6 ^ 3"), MathUtils.DEFAULT_DOUBLE_EQ_DELTA);
        Assert.assertEquals(Math.sin(485), calculator.calculate("sin 485"), MathUtils.DEFAULT_DOUBLE_EQ_DELTA);
        Assert.assertEquals(Math.cos(24), calculator.calculate("cos 24"), MathUtils.DEFAULT_DOUBLE_EQ_DELTA);
        Assert.assertEquals(24, calculator.calculate("abs(-24)"), MathUtils.DEFAULT_DOUBLE_EQ_DELTA);
    }

    @Test
    public void ParenthesesTest() {
        Assert.assertEquals(10, calculator.calculate("6+4"), MathUtils.DEFAULT_DOUBLE_EQ_DELTA);
        Assert.assertEquals(2, calculator.calculate("6-4"), MathUtils.DEFAULT_DOUBLE_EQ_DELTA);
        Assert.assertEquals(12, calculator.calculate("6*2"), MathUtils.DEFAULT_DOUBLE_EQ_DELTA);
        Assert.assertEquals(6.5 / 31, calculator.calculate("6.5 / 31"), MathUtils.DEFAULT_DOUBLE_EQ_DELTA);
        Assert.assertEquals(216, calculator.calculate("6 ^ 3"), MathUtils.DEFAULT_DOUBLE_EQ_DELTA);
        Assert.assertEquals(Math.sin(485), calculator.calculate("sin 485"), MathUtils.DEFAULT_DOUBLE_EQ_DELTA);
        Assert.assertEquals(Math.cos(24), calculator.calculate("cos 24"), MathUtils.DEFAULT_DOUBLE_EQ_DELTA);
        Assert.assertEquals(24, calculator.calculate("abs(-24)"), MathUtils.DEFAULT_DOUBLE_EQ_DELTA);
    }

    @Test
    public void UnaryNumberSignTest() {
        Assert.assertEquals(2, calculator.calculate(" + 2"), MathUtils.DEFAULT_DOUBLE_EQ_DELTA);
        Assert.assertEquals(-2, calculator.calculate(" -2"), MathUtils.DEFAULT_DOUBLE_EQ_DELTA);
        Assert.assertEquals(48, calculator.calculate(" 45 + (- 2 + 5)"), MathUtils.DEFAULT_DOUBLE_EQ_DELTA);
        Assert.assertEquals(-7, calculator.calculate(" - 2 - 5"), MathUtils.DEFAULT_DOUBLE_EQ_DELTA);
        Assert.assertEquals(3, calculator.calculate(" - 2 -- 5"), MathUtils.DEFAULT_DOUBLE_EQ_DELTA);
        Assert.assertEquals(-7, calculator.calculate(" - 2 +- 5"), MathUtils.DEFAULT_DOUBLE_EQ_DELTA);
        Assert.assertEquals(3, calculator.calculate(" (- 2*(-1)*(-1)) - (-5)"), MathUtils.DEFAULT_DOUBLE_EQ_DELTA);
    }

    @Test(expected = CalculationException.class)
    public void InfinityCalculationTest(){
        calculator.calculate(" 5 / 0");
    }

    @Test(expected = CalculationException.class)
    public void NanCalculationTest(){
        calculator.calculate(" 0.0 / 0.0");
    }

    @Test
    public void CapitalisationTest(){
        Assert.assertEquals(Math.cos(24), calculator.calculate("Cos 24"), MathUtils.DEFAULT_DOUBLE_EQ_DELTA);
        Assert.assertEquals(Math.cos(24), calculator.calculate("COS 24"), MathUtils.DEFAULT_DOUBLE_EQ_DELTA);
    }
}
