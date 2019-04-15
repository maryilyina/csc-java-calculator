package org.csc.nsk.java2017.impl.maryilyina.task02.expressions;

import org.csc.nsk.java2017.impl.maryilyina.task02.operators.BinaryOperator;

public class BinaryExpression extends Expression {

    private BinaryOperator _operator;
    private Expression _left_operand;
    private Expression _right_operand;

    public BinaryExpression(BinaryOperator operator, Expression left_operand, Expression right_operand) {
        super(ExpressionType.Binary);
        _operator = operator;
        _left_operand = left_operand;
        _right_operand = right_operand;
    }

    @Override
    public double eval() {
        return _operator.eval(_left_operand, _right_operand);
    }
}