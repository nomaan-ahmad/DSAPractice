package Recursion$Backtracking;

public class PowerUsingRecursion {
    public double myPow(double x, int n) {
        int abs = Math.abs(n);

        return (n>=0) ? helper(x, abs) : 1/helper(x,abs);
    }

    public double helper(double x, int n) {
        if (n == 1) return x;

        int mid = n/2;

        double halfPow = myPow(x, mid);

        if (n % 2 == 0) return halfPow * halfPow;
        else return halfPow * x * halfPow;
    }
}
