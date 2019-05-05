package org.csc.nsk.java2017.impl.maryilyina.task02.operators.registered_operators;

import org.csc.nsk.java2017.impl.maryilyina.task02.expressions.Expression;
import org.csc.nsk.java2017.impl.maryilyina.task02.operators.UnaryOperator;

public class AbsOperator extends UnaryOperator {

    @Override
    public String keyword() {
        return "abs";
    }

    @Override
    public double eval(Expression operand) {
        Double res = operand.eval();
        if (res >= 0) return res;
        return -res;
    }
}
