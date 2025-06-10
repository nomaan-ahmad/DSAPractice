package Hashing;

// https://leetcode.com/problems/maximum-difference-between-even-and-odd-frequency-i/
public class MaximumDifferenceBetweenEvenAndOddFrequency_1 {
    public static int maxDifference(String s) {
        int[] frq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            frq[s.charAt(i) - 'a']++;
        }

        int evenMin = Integer.MAX_VALUE;

        int oddMax = Integer.MIN_VALUE;

        for (int j : frq) {
            if (j != 0) {
                if ((j & 1) == 0) {
                    evenMin = Math.min(evenMin, j);

                } else {

                    oddMax = Math.max(oddMax, j);
                }
            }
        }

        return oddMax - evenMin;
    }

    public static void main(String[] args) {
        String s = "tzt";
        System.out.println(maxDifference(s));
    }
}
