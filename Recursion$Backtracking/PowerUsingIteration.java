package Recursion$Backtracking;

// Solving power(x,n) is much more efficient solving using iteration than recursion because of usage of less memory.
public class PowerUsingIteration {
    private static final int MOD = 1_000_000_007;
    public static void main(String[] args) {
        System.out.println(pow(5, 5));
    }
    public static long pow(long x, long n) {
        if (n == 0) return 1;
        if (n == 1) return x;

        if (n < 0) {
            n = -1 * n;
            x = 1/x;
        }

        long ans = 1;
        long base = x;

        while (n > 0) {
            if (n % 2 == 1) {
                ans = (ans * base) % MOD;
                n--;
            } else {
                base = (base * base) % MOD;
                n = n/2;
            }
        }

        return ans;
    }
}
