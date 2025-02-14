package Precomputation;

// https://leetcode.com/problems/number-of-ways-to-split-array

public class NumberOfWaysToSplitArray {
    // using prefix sum array
    public int waysToSplitArray(int[] nums) {
        int result = 0;
        long[] prefixSum = new long[nums.length];

        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            prefixSum[i] = sum;
        }

        for (int i = 0; i < nums.length-1; i++) {
            long left = prefixSum[i];
            long right = sum - prefixSum[i];

            if (left >= right) result++;
        }

        return result;
    }

    // without using prefix sum array
    public int waysToSplitArrayII(int[] nums) {
        long sum = 0;

        for (int i : nums) {
            sum += i;
        }

        int result = 0;
        long aux = 0;
        for (int i = 0; i < nums.length-1; i++) {
            aux += nums[i];

            if (aux >= (sum-aux)) result++;
        }

        return result;
    }
}
