package org.csc.nsk.java2017.impl.maryilyina.task02;

import org.csc.nsk.java2017.task02.Calculator;

public final class MathCalculator implements Calculator {

    private Parser parser = new Parser();

    @Override
    public double calculate(final String expression) {
        return parser.parseExpression(expression).eval();
    }
}
