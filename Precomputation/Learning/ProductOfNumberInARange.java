package Precomputation.Learning;

/**
 * We have been given an array of size 'n' containing numbers 0 <= nums[i] <= 100. You have been given multiple queries
 * in the form of (i,j) index. The task is to find the product of numbers within the range mentioned in the query.
 * */
public class ProductOfNumberInARange {
    public static void main(String[] args) {
        int[] nums = {0, 2, 3, 4};
        int start = 1;
        int end = 2;
        System.out.println(product(nums, start, end));
    }

    private static long product(int[] nums, int start, int end) {
        int len = nums.length;
        if (start < 0 || end < 0 || start > len || end > len) return -1;

        long[] prefixProduct = new long[len];
        int[] zeroCount = new int[len];
        if (zeroCount[0] == 0) zeroCount[0] = 1;

        for (int i = 1; i < len; i++) {
            prefixProduct[i] = (nums[i-1] == 0) ? nums[i] : ((long) nums[i] * prefixProduct[i-1]);
            zeroCount[i] += (nums[i] == 0) ? 1 : 0;
        }

        if (zeroCount[start] != zeroCount[end]) return 0;

        return prefixProduct[start-1] == 0 ? prefixProduct[end] : prefixProduct[end] / prefixProduct[start-1];
    }
}
