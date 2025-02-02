package Array;

// https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/description/
public class CheckIfArrayIsSortedAndRotated {
    public static void main(String[] args) {
        int[] arr = {3,4,5,1,2};
        System.out.println(check(arr));
    }

    public static boolean check(int[] nums) {
        if (nums.length == 1) return true;

        int len = nums.length;

        int idx = 1;
        while (idx < len) {
            if (nums[idx] < nums[idx-1]) break;
            idx++;
        }

        if (idx == len) return true;

        if (nums[0] < nums[len-1]) return false;

        idx++;
        while (idx < len) {
            if (nums[idx] < nums[idx-1]) return false;
            idx++;
        }

        return true;
    }
}
