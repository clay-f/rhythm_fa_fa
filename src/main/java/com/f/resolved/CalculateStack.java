package com.f.resolved;

import com.f.rhythm.base.Stack;
import com.f.rhythm.helper.StdIn;

public class CalculateStack {

    public static void main(String[] args) {
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();

        while (!StdIn.isEmpty()) {
            String s = StdIn.readLine();
            switch (s) {
                case "(":
                    continue;
                case "+":
                    ops.push("+");
                    continue;
                case "-":
                    ops.push("-");
                    continue;
                case "*":
                    ops.push("*");
                    continue;
                case "/":
                    ops.push("/");
                    continue;
                case ")":
                    Double one = vals.pop();
                    String op = ops.pop();
                    if (op.equals("+")) {
                        vals.push(one + vals.pop());
                    } else if (op.equals("-")) {
                        vals.push(one - vals.pop());
                    } else if (op.equals("*")) {
                        vals.push(one * vals.pop());
                    } else if (op.equals("/")) {
                        vals.push(one / vals.pop());
                    }
                    continue;
                default:
                        vals.push(Double.parseDouble(s));
            }
        }

        for (Double item : vals) {
            System.out.println(item);
        }

    }
}
