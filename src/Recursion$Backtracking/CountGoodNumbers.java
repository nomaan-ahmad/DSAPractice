package Recursion$Backtracking;

// Problem statement: https://leetcode.com/problems/count-good-numbers/description/
public class CountGoodNumbers {
    private static final long MOD = 1_000_000_007;
    public static void main(String[] args) {
        System.out.println(countGoodNumbers(5));
    }
    public static int countGoodNumbers(long n) {
        if (n == 1) return 5;
        long exponent = n/2;

        long even = (n % 2 == 0) ? pow(5, exponent) : pow(5, exponent + 1);
        long odd = pow(4, exponent);

        return (int)((even * odd) % MOD);
    }

    // n^m
    private static long pow(long n, long m) {
        if (m == 0) return 1;
        if (m == 1) return n;

        Long half = pow(n, m/2) % MOD;

        if (m % 2 == 0) return (half * half) % MOD;
        else return (half * n * half) % MOD;
    }
}
