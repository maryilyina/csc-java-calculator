package org.csc.nsk.java2017.impl.maryilyina.task02;

import org.csc.nsk.java2017.impl.maryilyina.task02.expressions.*;
import org.csc.nsk.java2017.impl.maryilyina.task02.operators.Operator;
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
        return input.substring(1, input.length() - 1);
    }

    public Expression parseExpression(String input) {
        return parseExpressionWithoutSpaces(input.replaceAll("\\s+", ""));
    }

    public Expression parseExpressionWithoutSpaces(String input) {
        input = clearEnclosingParentheses(input);

        if (isNumber(input)) {
            double d = Double.valueOf(input);
            return new LiteralExpression(d);
        }

        int curPriority = OperatorsLoader.maxPriority();
        // go from highest priority of operator to lowest
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
                    int start = curPos;
                    // read while it is operator name and no other symbol
                    while (curPos < input.length() && !haveReadNumber(input, curPos, curPos + 1) &&
                            input.charAt(curPos) != '(' && input.charAt(curPos) != ')' &&
                            !OperatorsLoader.contains(input.substring(start, curPos)))
                        curPos++;

                    if (curPos > start) {
                        String operatorName = input.substring(start, curPos);
                        if (!OperatorsLoader.contains(operatorName))
                            throw new BadSyntaxException("Not supported operator " + operatorName);

                        // skip if it is not the current priority
                        // or if expression is inside the parentheses
                        if (OperatorsLoader.getOperatorPriority(operatorName) != curPriority
                                || parenthesesCount != 0) continue;

                        Operator operator = OperatorsLoader.getOperator(operatorName);

                        // skip if unary minus
                        if (operatorName.equals("-") && curPos == 1) continue;

                        // parse expression going before the operator
                        Expression leftExpr = parseExpression(input.substring(0, start));
                        // parse expression going after the operator
                        Expression rightExpr = parseExpression(input.substring(curPos));

                        ArrayList<Expression> args = new ArrayList<>();
                        if (leftExpr != null)  args.add(leftExpr);
                        if (rightExpr != null) args.add(rightExpr);

                        return operator.apply(args);
                    }
                }
            }
            curPriority--;
        }
        return null;
    }
}