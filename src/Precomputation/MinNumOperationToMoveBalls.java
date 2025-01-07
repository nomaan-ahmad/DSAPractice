package Precomputation;

// https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/?

import java.util.Arrays;

public class MinNumOperationToMoveBalls {
    public static void main(String[] args) {
        String s = "001011";
        System.out.println(Arrays.toString(minOperations(s)));
    }

    public static int[] minOperations(String boxes) {
        int rightSum = 0;
        int rightCount = 0;

        int[] result = new int[boxes.length()];

        for (int i = 0; i < boxes.length(); i++) {
            if (boxes.charAt(i) == '1') {
                rightCount++;
                rightSum += i;
            }
        }

        int leftCount = 0;
        int leftSum = 0;

        for (int i = 0; i < boxes.length(); i++) {
            leftSum += leftCount;

            if (boxes.charAt(i) == '1') {
                leftCount++;
                rightCount--;
            }

            result[i] = leftSum + rightSum;

            rightSum -= rightCount;
        }

        return result;
    }
}
