package Precomputation;

// https://leetcode.com/problems/maximum-score-after-splitting-a-string/description/
public class MaximumScoreAfterSplittingAString {
    public static void main(String[] args) {
        String s = "1111";
        System.out.println(maxScore(s));
    }

    public static int maxScore(String s) {
        int result = Integer.MIN_VALUE;
        int one = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') one++;
        }

        int zero = 0;

        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i) == '0') zero++;
            else one--;

            result = Math.max(one + zero, result);
        }

        return result;
    }
}
