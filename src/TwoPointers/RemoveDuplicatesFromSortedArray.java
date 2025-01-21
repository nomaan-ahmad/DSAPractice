package TwoPointers;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array/

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates_II(nums));
        System.out.println(removeDuplicates(nums));
    }

    // In below method I am swapping and making sure that no element's value is getting deleted or overwrite
    public static int removeDuplicates(int[] nums) {
        int left = 1, right = 1;

        while (right < nums.length) {
            if (nums[right] != nums[left-1]) {

                // swapping
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;

                // increment
                left++;
            }

            right++;
        }

        return left;
    }


    // in this approach we are not going to swap element rather going to just assign the value
    public static int removeDuplicates_II(int[] nums) {
        int left = 0, right = 0;

        while (right < nums.length) {
            if (nums[left] != nums[right]) {
                nums[++left] = nums[right];
            }

            right++;
        }

        return left+1;
    }
}
