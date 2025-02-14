package Array;

// problem statement: https://leetcode.com/problems/remove-element/description/
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            if (nums[low] == val) {
                swap(nums, low, high);
                high--;
            }else low++;
        }

        return high+1;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
