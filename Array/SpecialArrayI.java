package Array;

// https://leetcode.com/problems/special-array-i/
public class SpecialArrayI {
    public static void main(String[] args) {
        int[] nums = {1,2,1,8,7};
        System.out.println(isArraySpecial(nums));
    }

    public static boolean isArraySpecial(int[] nums) {
        if (nums.length == 1) return true;

        int first = (nums[0] & 1) == 1 ? 1 : 0;
        int second = (nums[1] & 1) == 1 ? 1 : 0;

        if (first == second) return false;

        int i = 3;
        while (true) {
            if ((i-1) < nums.length) {
                if ((nums[i-1] & 1) != first) return false;
            } else break;

            if (i < nums.length) {
                if ((nums[i] & 1) != second) return false;
            } else break;

            i = i+2;
        }

        return true;
    }
}