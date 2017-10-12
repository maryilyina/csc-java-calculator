/*
 * Task 02 - Calculator
 * CSC Nsk Java 2017
 * Created by frikadelki on 2017/10/12
 */

package org.csc.nsk.java2017.task02;

public interface Calculator {
    /**
     * Calculates given string expression.
     * All calculations & numbers parsing should be performed with {@code double} type.
     * Scientific number notation (1.11e-11) should be supported.
     * The following operations should be supported:
     * plus         ("+"),
     * minus        ("-"),
     * multiply     ("*"),
     * divide       ("/"),
     * power        ("^"),
     * parenthesis  ("()"),
     * number sign  ("+", "-")
     * functions    ("sin", "cos", "abs")
     * Whitespaces should be ignored and function names should all be case insensitive.
     *
     * @param expression expression to calculate
     * @return calculation result
     * @throws BadSyntaxException if the input string syntax is invalid
     * @throws CalculationException if calculation cannot be completed because of 0 division or other such things.
     */
    double calculate(String expression) throws BadSyntaxException, CalculationException;
}
