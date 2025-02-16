package Precomputation.Learning;

/**
 * So the problem is that you have to find the product of last K numbers of an array. Array contains 'n' elements ranging
 * from 0 <= nums[i] <= 100.

 * But the catch is that you have been given multiple queries around ~ 10^4 for any array. A query contains a number K
 * and you have to process each query as efficient as possible. Query wants you to find product of last K elements of
 * an array.

 * We can assume that each query will not result in any kind of overflow issue.
**/

public class ProductOfLastKNumbers {
    public static void main(String[] args) {
        int[] nums = {1,5,6,0,6,7,2,1,3,3};
        int k = 121;
        System.out.println(productOfLast_K_Nums(nums, k));
    }


    private static long productOfLast_K_Nums(int[] nums, int k) {
        // Let's preprocess the array from the end calculating the product of last k elements. We are going to use concept
        // of pre-computation/pre-processing our objective beforehand to process all queries efficiently with O(1) time
        // complexity

        for (int i = nums.length - 2; i >= 0; i--) {
            nums[i] *= nums[i+1];
        }

        return k > nums.length ? -1 : nums[nums.length-k];
    }
}
