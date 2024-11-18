package Recursion$Backtracking;

// https://leetcode.com/problems/string-to-integer-atoi/description/
public class StringToIntegerAtoi {
    public static void main(String[] args) {
        String s = "1337c0d3";

        System.out.println(myAtoi(s));
    }
    
    public static int myAtoi(String s) {
        if (s.length() == 0) return 0;

        // ignoring all the whitespace till we found a token other than it
        int index = 0;
        while (index < s.length() && s.charAt(index) == 32) index++;

        if (index >= s.length()) return 0;

        if (s.charAt(index) == '-') return helper(s, index+1, -1, 0);
        else if (s.charAt(index) == '+') return helper(s, index+1, 1, 0);
        else return helper(s, index, 1, 0);
    }

    private static int helper(String s, int index, int sign, long result) {
        if (index >= s.length()) return (int) (sign * result);

        char ch = s.charAt(index);

        if (!Character.isDigit(ch)) return (int) (sign * result);

        result = (result * 10) + ((long) (ch - '0'));

        if (result * sign > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (result * sign < Integer.MIN_VALUE) return Integer.MIN_VALUE;

        return helper(s, index+1, sign, result);
    }

    /*private int helper(String s, int index, boolean sign) {
        if (index >= s.length()) return 0;
        char ch = s.charAt(index);


        if (!((ch >= 48 && ch <= 57) || ch == 32 || ch == 45 || ch == 43)) return 0;

        if (ch == 45 || ch == 43) {
            if (sign) return 0;

            sign = true;
        }

        int num = helper(s, index++, sign);


        return 0;
    }*/
}
