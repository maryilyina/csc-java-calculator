package org.csc.nsk.java2017.impl.maryilyina.task02.operators.registered_operators;

import org.csc.nsk.java2017.impl.maryilyina.task02.expressions.Expression;
import org.csc.nsk.java2017.impl.maryilyina.task02.operators.UnaryOperator;

public class CosOperator extends UnaryOperator {

    @Override
    public String keyword() {
        return "cos";
    }

    @Override
    public Double eval(Expression operand) {
        return Math.cos(operand.eval());
    }
}
