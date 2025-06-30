package Sorting;

import java.util.Arrays;

// https://leetcode.com/problems/longest-harmonious-subsequence/description/
public class LongestHarmoniousSubsequence {
    public static int findLHS(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);

        int max = Integer.MIN_VALUE;
        int start, end = 0, mid = 0;
        while (end < len) {
            start = mid;
            while (end < len && nums[start] == nums[end]) end++;

            if (end == len) break;
            if (nums[end] - nums[start] == 1) mid = end;
            else {
                mid = end;
                continue;
            }

            while (end < len && nums[end] - nums[start] == 1) end++;
            max = Math.max(max, end - start);
        }

        return max == Integer.MIN_VALUE ? 0 : max;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,2,2,5,2,3,7};

        System.out.println(findLHS(nums));
    }
}
