package org.csc.nsk.java2017.impl.maryilyina.task02.operators.registered_operators;

import org.csc.nsk.java2017.impl.maryilyina.task02.expressions.Expression;
import org.csc.nsk.java2017.impl.maryilyina.task02.operators.UnaryOperator;

import java.util.ArrayList;
import java.util.List;

public class UnaryMinusOperator extends UnaryOperator {

    @Override
    public String keyword() {
        return "--";
    }

    @Override
    public double eval(Expression operand) {
        return - operand.eval();
    }
}
