package org.csc.nsk.java2017.impl.maryilyina.task02;

import org.csc.nsk.java2017.impl.maryilyina.task02.operators.*;
import org.csc.nsk.java2017.impl.maryilyina.task02.operators.registered_operators.*;

import java.util.HashMap;
import java.util.Map;

public class OperatorsLoader {
    private static int priority = 0;
    private static Map<String, Operator> registeredOperators = new HashMap<>();
    private static Map<String, Integer>  operatorPriorities  = new HashMap<>();

    public static void registerOperators(Operator ...operators) {
        for (Operator operator : operators) {
            registeredOperators.put(operator.keyword(), operator);
            operatorPriorities.put(operator.keyword(), priority);
        }
        priority++;
    }

    public static Integer maxPriority() {
        return priority - 1;
    }

    static {
        // priority 0
        registerOperators(new UnaryMinusOperator());
        // priority 1
        registerOperators(new PowerOperator(), new AbsOperator(), new SinOperator(), new CosOperator(), new SqrtOperator());
        // priority 2
        registerOperators(new MultOperator(), new DivisionOperator());
        // priority 3
        registerOperators(new AdditionOperator(), new SubstractionOperator());
    }

    public static boolean contains(String operator) {
        return registeredOperators.containsKey(operator);
    }

    public static Operator getOperator(String operator) {
        return registeredOperators.get(operator);
    }

    public static Integer getOperatorPriority(String operator) {
        return operatorPriorities.get(operator);
    }
}
