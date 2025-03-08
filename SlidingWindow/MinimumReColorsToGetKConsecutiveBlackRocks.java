package SlidingWindow;

// https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks
public class MinimumReColorsToGetKConsecutiveBlackRocks {
    public static void main(String[] args) {
        String block = "WBBWWBBWBW";
        int k = 7;

        System.out.println(minimumRecolors(block, k));
    }

    public static int minimumRecolors(String blocks, int k) {
        int countOfWhiteInWindow = 0;

        // Creating first window
        int i = 0;
        while (i < k) {
            if (blocks.charAt(i++) == 'B') countOfWhiteInWindow++;
        }

        int max = countOfWhiteInWindow;
        if (countOfWhiteInWindow == k) return 0;

        while (i < blocks.length()) {
            if (blocks.charAt(i) == 'B') countOfWhiteInWindow++;
            if (blocks.charAt(i-k) == 'B') countOfWhiteInWindow--;
            i++;

            max = Math.max(countOfWhiteInWindow, max);

            if (max == k) return 0;
        }

        return k - max;
    }
}
