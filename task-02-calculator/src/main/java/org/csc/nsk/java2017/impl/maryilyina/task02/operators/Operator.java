package org.csc.nsk.java2017.impl.maryilyina.task02.operators;

import org.csc.nsk.java2017.impl.maryilyina.task02.expressions.Expression;

import java.util.List;

public abstract class Operator {
    public abstract Expression apply(List<Expression> expressions);
    abstract double eval(List<Expression> expressions);
    public abstract String keyword();
}
