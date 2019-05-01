/*
 * Task 02 - Calculator
 * CSC Nsk Java 2017
 * Created by frikadelki on 2017/10/12
 */

package org.csc.nsk.java2017.task02;

import org.csc.nsk.java2017.impl.maryilyina.task02.MathCalculator;

final class CalculatorFactory {
    static Calculator makeCalculator() {
        return new MathCalculator();
    }

    private CalculatorFactory() {
    }
}
