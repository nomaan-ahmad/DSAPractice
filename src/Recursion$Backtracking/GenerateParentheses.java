package Recursion$Backtracking;

import java.util.ArrayList;
import java.util.List;

// Problem statement: https://leetcode.com/problems/generate-parentheses/
public class GenerateParentheses {
    public static void main(String[] args) {
        var result = generateParenthesis(3);
        System.out.println(result);
    }
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(0,0,  result, new StringBuilder(), n);
        return result;
    }

    private static void generate(int left, int right, List<String> result, StringBuilder sb, int n) {
        if (sb.length() == n*2) {
            result.add(sb.toString());
            return;
        }

        if (left > right && right < n) {
            sb.append(")");
            generate(left, right+1, result, sb, n);
            sb.deleteCharAt(sb.length()-1);
        }

        if (left < n) {
            sb.append("(");
            generate(left+1, right, result, sb, n);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
