/*
 * Task 02 - Calculator
 * CSC Nsk Java 2017
 * Created by frikadelki on 2017/10/12
 */

package org.csc.nsk.java2017.impl.frikadelki.task02;

import org.csc.nsk.java2017.task02.Calculator;


public final class DummyCalculator implements Calculator {
    @Override
    public double calculate(final String expression) {
        if ("1 + 1".equals(expression)) {
            return 2;
        }
        return 0;
    }
}
