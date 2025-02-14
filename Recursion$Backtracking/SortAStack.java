package Recursion$Backtracking;


import java.util.Stack;

// problem statement: https://www.geeksforgeeks.org/problems/sort-a-stack/1
public class SortAStack {
    public Stack<Integer> sort(Stack<Integer> s) {
        sortRecurse(s); // using only recursion
        //helper(s); // using extra stack
        return s;
    }

    private static void sortRecurse(Stack<Integer> s) {
        if (s.isEmpty()) return;

        int pop = s.pop();
        sortRecurse(s);
        insertSorted(s, pop);
    }

    // using only recursion
    private static void insertSorted(Stack<Integer> s, int val) {
        if (s.isEmpty() || s.peek() < val) {
            s.push(val);
            return;
        }

        int temp = s.pop();
        insertSorted(s, val);
        s.push(temp);
    }

    // using extra stack
    private static void helper(Stack<Integer> stack) {
        if (stack.isEmpty()) return;

        int poppedEle = stack.pop();
        helper(stack);

        Stack<Integer> aux = new Stack<>();
        while (!stack.isEmpty() && stack.peek() > poppedEle) aux.push(stack.pop());

        stack.push(poppedEle);
        while (!aux.isEmpty()) stack.push(aux.pop());
    }
}
