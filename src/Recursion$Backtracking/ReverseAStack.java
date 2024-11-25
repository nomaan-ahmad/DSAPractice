package Recursion$Backtracking;

import java.util.Stack;

// Problem statement: https://www.geeksforgeeks.org/problems/reverse-a-stack/1
public class ReverseAStack {
    public static void reverse(Stack<Integer> s) {
        if (s.isEmpty()) return;

        int temp = s.pop();
        reverse(s);
        insertAtEnd(s, temp);
    }

    private static void insertAtEnd(Stack<Integer> stack, int val) {
        if (stack.isEmpty()) {
            stack.push(val);
            return;
        }

        int temp = stack.pop();
        insertAtEnd(stack, val);
        stack.push(temp);
    }
}
