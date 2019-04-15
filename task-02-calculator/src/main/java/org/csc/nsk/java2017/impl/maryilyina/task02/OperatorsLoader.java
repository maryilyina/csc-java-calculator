package org.csc.nsk.java2017.impl.maryilyina.task02;

import org.csc.nsk.java2017.impl.maryilyina.task02.operators.*;
import org.csc.nsk.java2017.impl.maryilyina.task02.operators.registered_operators.*;

import java.util.HashMap;
import java.util.Map;

public class OperatorsLoader {
    private static Map<String, Operator> registeredOperators = new HashMap<>();

    public static void registerOperator(Operator operator) {
        registeredOperators.put(operator.keyword(), operator);
    }

    static {
        // Unary operators
        registerOperator(new AbsOperator());
        registerOperator(new UnaryMinusOperator());
        registerOperator(new SinOperator());
        registerOperator(new CosOperator());
        registerOperator(new SqrtOperator());

        // Binary operators
        registerOperator(new AdditionOperator());
        registerOperator(new SubstractionOperator());
        registerOperator(new MultOperator());
        registerOperator(new DivisionOperator());
        registerOperator(new PowerOperator());
    }

    public static boolean contains(String operator) {
        return registeredOperators.containsKey(operator);
    }

    public static Operator getOperator(String operator) {
        return registeredOperators.get(operator);
    }
}
