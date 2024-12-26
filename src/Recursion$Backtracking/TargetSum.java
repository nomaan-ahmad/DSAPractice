package Recursion$Backtracking;

// https://leetcode.com/problems/target-sum/description/
public class TargetSum {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int target = 3;

        System.out.println(findTargetSumWays(nums, target));
    }
    public static int findTargetSumWays(int[] nums, int target) {
        int[] result = {0};
        helper(nums, target, result, 0);
        return result[0];
    }

    private static void helper(int[] nums, int target, int[] result, int index) {
        if (index == nums.length) {
            if (target == 0) result[0] += 1;
            return;
        }

        helper(nums, target - nums[index], result, index + 1);
        helper(nums, target + nums[index], result, index + 1);
    }
}
