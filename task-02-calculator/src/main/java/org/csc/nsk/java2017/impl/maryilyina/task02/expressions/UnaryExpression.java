package org.csc.nsk.java2017.impl.maryilyina.task02.expressions;

import org.csc.nsk.java2017.impl.maryilyina.task02.operators.UnaryOperator;

public class UnaryExpression extends Expression {

    private UnaryOperator _operator;
    private Expression _operand;

    public UnaryExpression(UnaryOperator operator, Expression operand) {
        super(ExpressionType.Binary);
        _operator = operator;
        _operand = operand;
    }

    @Override
    public double eval() {
        return _operator.eval(_operand);
    }
}