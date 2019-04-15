package org.csc.nsk.java2017.impl.maryilyina.task02.expressions;

public class LiteralExpression extends Expression {

    private Double _value;

    public LiteralExpression(Double value) {
        super(ExpressionType.Literal);
        _value = value;
    }

    @Override
    public double eval() {
        return _value;
    }
}