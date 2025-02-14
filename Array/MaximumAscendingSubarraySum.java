package Array;

public class MaximumAscendingSubarraySum {
    public static void main(String[] args) {
        int[] nums = {10,20,30,5,10,50};
        System.out.println(maxAscendingSum(nums));
    }
    public static int maxAscendingSum(int[] nums) {
        if (nums.length == 1) return nums[0];
        int maxSum = 0;

        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i-1]) {
                maxSum = Math.max(sum, maxSum);
                sum = nums[i];
            }
            else sum += nums[i];
        }

        maxSum = Math.max(sum, maxSum);
        return maxSum;
    }
}
