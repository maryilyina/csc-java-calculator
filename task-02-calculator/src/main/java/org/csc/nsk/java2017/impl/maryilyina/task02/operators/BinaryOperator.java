package org.csc.nsk.java2017.impl.maryilyina.task02.operators;

import org.csc.nsk.java2017.impl.maryilyina.task02.expressions.*;
import org.csc.nsk.java2017.task02.BadSyntaxException;

import java.util.List;

public abstract class BinaryOperator extends Operator {

    public abstract double eval(Expression left_operand, Expression right_operand);

    @Override
    public Expression apply(List<Expression> expressions) {
        if (expressions.size() == 2)
            return new BinaryExpression(this, expressions.get(0), expressions.get(1));
        throw new BadSyntaxException("Binary operator " + keyword() + " expected two arguments.\n" +
                "Note: Unary operator should be written afterwards and as '--'.");
    }

    @Override
    double eval(List<Expression> expressions) {
        if (expressions.size() == 2)
            return eval(expressions.get(1), expressions.get(0));
        throw new BadSyntaxException("Binary operator " + keyword() + "  expected two arguments.");
    }
}
