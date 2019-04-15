package org.csc.nsk.java2017.impl.maryilyina.task02.expressions;

enum ExpressionType {
    Literal, Unary, Binary
}

public abstract class Expression {
    Expression(ExpressionType type) {}
    public abstract double eval();
}
