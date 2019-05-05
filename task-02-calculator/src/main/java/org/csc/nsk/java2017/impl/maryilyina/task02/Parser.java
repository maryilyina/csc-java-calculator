package org.csc.nsk.java2017.impl.maryilyina.task02;

import org.csc.nsk.java2017.impl.maryilyina.task02.expressions.*;
import org.csc.nsk.java2017.impl.maryilyina.task02.operators.Operator;
import org.csc.nsk.java2017.impl.maryilyina.task02.operators.registered_operators.UnaryMinusOperator;
import org.csc.nsk.java2017.task02.BadSyntaxException;

import java.util.ArrayList;

public class Parser {
    private boolean haveReadNumber(String str, int from, int to) {
        try {
            Double.valueOf(str.substring(from, to));
            return true;
        }
        catch (NumberFormatException e) { return false; }
    }

    private boolean isNumber(String str) {
        return haveReadNumber(str, 0, str.length());
    }

    public String clearEnclosingParentheses(String input) {
        if (input.length() < 2) return input;
        // if no closing parentheses around the expression
        if (input.charAt(0) != '(' || input.charAt(input.length() - 1) != ')') return input;

        int parenthesesCount = 0;
        for (int i = 0; i < input.length() - 1; ++i) {
            if (input.charAt(i) == '(')
                parenthesesCount++;
            else if (input.charAt(i) == ')')
                parenthesesCount--;
            if (parenthesesCount == 0) return input;
        }
        return clearEnclosingParentheses(input.substring(1, input.length() - 1));
    }

    public Expression parseExpression(String input) {
        String cleared = input.replaceAll("\\s+", "").toLowerCase();
        if (cleared.equals("")) throw new BadSyntaxException("Empty input");
        return parseClearExpression(cleared);
    }

    public Expression parseClearExpression(String input) {
        input = clearEnclosingParentheses(input);

        if (isNumber(input)) {
            double d = Double.valueOf(input);
            return new LiteralExpression(d);
        }

        int curPriority = OperatorsLoader.minPriority();
        boolean hadUnarySign = false;
        String unarySign = null;

        // go from lowest priority of operator to top to parse correctly
        while (curPriority >= 0) {
            int curPos = 0;
            int parenthesesCount = 0;
            while (curPos < input.length()) {
                char symbol = input.charAt(curPos);
                if (symbol == ' ') curPos++;
                else if (symbol == '(') {
                    curPos++;
                    parenthesesCount++;
                }
                else if (symbol == ')') {
                    curPos++;
                    parenthesesCount--;
                }
                else if (haveReadNumber(input, curPos, curPos + 1)) {
                    // read while it is double value
                    int start = curPos;
                    while (curPos < input.length() && haveReadNumber(input, start, curPos + 1))
                        curPos++;
                }
                else {
                    int operatorStart = curPos;
                    // read while it is operator name and no other symbol
                    while (curPos < input.length() && !haveReadNumber(input, curPos, curPos + 1) &&
                            input.charAt(curPos) != '(' && input.charAt(curPos) != ')' &&
                            !OperatorsLoader.contains(input.substring(operatorStart, curPos)))
                        curPos++;
                    int operatorEnd = curPos;

                    String operatorName = input.substring(operatorStart, operatorEnd);

                    // skip if it is unary minus or plus
                    if ((operatorName.equals("-") || operatorName.equals("+") ) && operatorEnd == 1) {
                        hadUnarySign = true;
                        unarySign = operatorName;
                        continue;
                    }
                    // skip if it is decimal mark or exponential form 'e-'
                    if (operatorName.equals(".") || operatorName.equals("e-"))
                        continue;

                    if (!OperatorsLoader.contains(operatorName))
                        throw new BadSyntaxException("Not supported operator " + operatorName);

                    // skip if it is not the current priority
                    // or if expression is inside the parentheses
                    if (OperatorsLoader.getOperatorPriority(operatorName) != curPriority
                            || parenthesesCount != 0) continue;

                    Operator operator = OperatorsLoader.getOperator(operatorName);

                    ArrayList<Expression> args = new ArrayList<>();
                    // parse expression going before the operator
                    if (operatorStart > 0)
                        args.add(parseClearExpression(input.substring(0, operatorStart)));
                    // parse expression going after the operator
                    if (operatorEnd < input.length())
                        args.add(parseClearExpression(input.substring(operatorEnd)));

                    return operator.apply(args);
                }
            }
            curPriority--;
        }

        // had only unary minus and no other operators in expression
        if (hadUnarySign){
            Expression expr = parseClearExpression(input.substring(1));
            if (unarySign.equals("+"))
                return expr;
            else if (unarySign.equals("-"))
                return new UnaryMinusOperator().apply(expr);
        }

        throw new BadSyntaxException("Parsing failed");
    }
}