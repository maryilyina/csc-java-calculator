package org.csc.nsk.java2017.impl.maryilyina.task02.operators.registered_operators;

import org.csc.nsk.java2017.impl.maryilyina.task02.expressions.Expression;
import org.csc.nsk.java2017.impl.maryilyina.task02.operators.BinaryOperator;

public class PowerOperator extends BinaryOperator {

    @Override
    public String keyword() {
        return "^";
    }

    @Override
    public double eval(Expression left, Expression right) {
        return Math.pow(left.eval(), right.eval());
    }
}
