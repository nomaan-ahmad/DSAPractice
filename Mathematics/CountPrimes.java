package Mathematics;

// https://leetcode.com/problems/count-primes

public class CountPrimes {
    public static void main(String[] args) {
        int n = 2;
        System.out.println(countPrimes(n));
    }

    public static int countPrimes(int n) {
        if (n == 0 || n == 1) return 0;

        int count = 0;
        boolean[] isNotPrime = new boolean[n+1];
        isNotPrime[0] = true;
        isNotPrime[1] = true;

        for (int i = 2; i * i <= n; i++) {
            if (!isNotPrime[i]) {
                for (int j = i*i; j <= n; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }

        for (int i = 0; i < isNotPrime.length-1; i++)
            if (!isNotPrime[i]) count++;

        return count;
    }
}
