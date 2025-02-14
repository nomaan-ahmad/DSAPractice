package Array;

// problem statement: https://leetcode.com/problems/rotate-array/description/
public class RotateArray {
    public void rotate(int[] nums, int k) {
        final int n = nums.length;
        k = k % n;

        if (k == 0) return;

        rotateHelper(nums, 0, n-k-1);
        rotateHelper(nums, n-k, n-1);
        rotateHelper(nums, 0, n-1);
    }

    private static void rotateHelper(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
    }
}
