package com.f.resolved;


import com.f.rhythm.base.Stack;

import java.util.List;
import java.util.Scanner;

public class Parentheses {
    public static void main(String[] args) {
        List<String> characters = List.of("{", "[", "(", ")", "]", "}");
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        Scanner input = new Scanner(System.in);
        System.out.printf("输入字符: ");
        char[] inputCharaters = input.nextLine().toCharArray();

        int n = inputCharaters.length;
        for (int i = 0; i < n / 2; i++) {
            left.push(inputCharaters[i]);
            right.push(inputCharaters[n - 1 - i]);
        }

        System.out.println("字符队列是否相等: " + ispaired(left, right));
    }


    public static boolean ispaired(Stack<Character> left, Stack<Character> right) {
        boolean flag = true;
        int n = left.size();

        for (int i = 0; i < n; i++) {
            Character character =left.pop();
            switch (character) {
                case '(':
                    if (right.pop() != ')') flag = false;
                    break;
                case '[':
                    if (right.pop() != ']') flag = false;
                    break;
                case '{':
                    if (right.pop() != '}') flag = false;
                    break;
            }
        }
        return flag;
    }
}
