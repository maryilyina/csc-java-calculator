package org.csc.nsk.java2017.impl.maryilyina.task02.operators;

import org.csc.nsk.java2017.impl.maryilyina.task02.expressions.Expression;
import org.csc.nsk.java2017.impl.maryilyina.task02.expressions.UnaryExpression;
import org.csc.nsk.java2017.task02.BadSyntaxException;

import java.util.List;

public abstract class UnaryOperator extends Operator {

    public abstract Double eval(Expression operand);

    @Override
    public Expression apply(List<Expression> expressions) {
        if (expressions.size() == 1)
            return new UnaryExpression(this, expressions.get(0));
        throw new BadSyntaxException("Unary operator $keyword expected one argument.\n" +
                "Note: Unary operator should be written afterwards and as '--'.");
    }

    @Override
    double eval(List<Expression> expressions) {
        if (expressions.size() == 1)
            return eval(expressions.get(0));
        throw new BadSyntaxException("Unary operator $keyword expected one argument.");
    }
}
