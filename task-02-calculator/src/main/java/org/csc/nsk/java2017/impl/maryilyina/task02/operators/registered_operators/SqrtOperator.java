package org.csc.nsk.java2017.impl.maryilyina.task02.operators.registered_operators;

import org.csc.nsk.java2017.impl.maryilyina.task02.expressions.Expression;
import org.csc.nsk.java2017.impl.maryilyina.task02.operators.UnaryOperator;

public class SqrtOperator extends UnaryOperator {


    @Override
    public String keyword() {
        return "sqrt";
    }

    @Override
    public Double eval(Expression operand) {
        return Math.sqrt(operand.eval());
    }
}
