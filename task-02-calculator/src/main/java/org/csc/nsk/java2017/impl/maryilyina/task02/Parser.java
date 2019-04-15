package org.csc.nsk.java2017.impl.maryilyina.task02;

import org.csc.nsk.java2017.impl.maryilyina.task02.expressions.*;
import org.csc.nsk.java2017.impl.maryilyina.task02.operators.Operator;
import org.csc.nsk.java2017.task02.BadSyntaxException;

import java.util.ArrayList;
import java.util.Stack;

public class Parser {
    enum SyntaxConstruction {
        LeftBracket, RightBracket, Expression, Operator
    }

    private Stack<Expression> expressionStack;
    private Stack<SyntaxConstruction> constrStack;

    private boolean haveReadNumber(String str, int from, int to) {
        try {
            Double.valueOf(str.substring(from, to));
            return true;
        }
        catch (NumberFormatException e) { return false; }
    }


    public Expression parseExpression(String input) {
        int cur_pos = 0;

        expressionStack = new Stack<>();
        constrStack = new Stack<>();

        while (cur_pos < input.length()) {
            if (input.charAt(cur_pos) == ' ') cur_pos++;
            else if (input.charAt(cur_pos) == '(') {
                cur_pos++;
                constrStack.push(SyntaxConstruction.LeftBracket);
            }
            else if (input.charAt(cur_pos) == ')') {
                cur_pos++;
                //constrStack.push(SyntaxConstruction.RightBracket);
            }
            if (cur_pos >= input.length()) break;
            if (haveReadNumber(input, cur_pos, cur_pos + 1)) {
                int start = cur_pos;
                while(cur_pos < input.length()
                        && haveReadNumber(input, start, cur_pos + 1))
                    cur_pos++;
                double d = Double.valueOf(input.substring(start, cur_pos));

                constrStack.push(SyntaxConstruction.Expression);
                expressionStack.push(new LiteralExpression(d));
            }
            else {
                int start = cur_pos;
                while (cur_pos < input.length() && input.charAt(cur_pos) != ' ' &&
                        !haveReadNumber(input, cur_pos, cur_pos + 1) &&
                        input.charAt(cur_pos) != '(' && input.charAt(cur_pos) != ')')
                    cur_pos++;

                if (cur_pos > start) {
                    String operator = input.substring(start, cur_pos);
                    if (!OperatorsLoader.contains(operator))
                        throw new BadSyntaxException("Not supported operator $operator");

                    //constrStack.push(SyntaxConstruction.Operator)
                    processExpr(OperatorsLoader.getOperator(operator));
                }
            }
        }
        return expressionStack.pop();
    }

    private void processExpr(Operator operator) {
        ArrayList<Expression> args = new ArrayList<>();

        while (!constrStack.empty()) {
            SyntaxConstruction construction = constrStack.pop();
            if (construction == SyntaxConstruction.LeftBracket)     break;
            else if (construction == SyntaxConstruction.Operator)   break;
            else if (construction == SyntaxConstruction.Expression) {
                if (!expressionStack.empty())
                    args.add(expressionStack.pop());
                else throw new BadSyntaxException("Empty construction stack");
            }
        }

        Expression res = operator.apply(args);
        expressionStack.add(res);
        constrStack.add(SyntaxConstruction.Expression);
    }
}