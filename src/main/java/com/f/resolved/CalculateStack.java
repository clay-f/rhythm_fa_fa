package com.f.resolved;

import com.f.rhythm.base.Stack;
import com.f.rhythm.helper.StdIn;

public class CalculateStack {

    public static void main(String[] args) {
        bracketPair();
    }


    public static void calcStack() {
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

    public static void testCopyStack() {
        Stack<String> a = new Stack<>();
        a.push("a");
        a.push("b");
        Stack.copy(a).forEach(x -> {
            System.out.println(x);
        });

    }


    public static void bracketPair() {
        Stack<String> ops = new Stack<>();
        Stack<String> vals = new Stack<>();

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();

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
                    String one = vals.pop();
                    if (!ops.isEmpty()) {
                        String opr = ops.pop();
                        String other = vals.pop();
                        vals.push(String.format("(%s %s %s)", one, opr, other));
                    } else {
                        vals.push(String.format("(%s)", one));
                    }
                    continue;
                    default:
                        vals.push(s);
            }
        }

        for (String item : vals) {
            System.out.println(item);
        }

    }
}
