package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {
    public static List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            helper(result, 0, i, n);
        }

        return result;
    }

    private static void helper(List<Integer> result, int num, int add, int n) {
        int newNum = (num*10) + add;

        if (newNum <= n) {
            result.add(newNum);
        } else return;

        for (int i = 0; i < 10; i++) {
            helper(result, newNum, i, n);
        }
    }

    public static void main(String[] args) {
        int n = 13;
        System.out.println(lexicalOrder(n));
    }
}