package BitManipulation;

// https://leetcode.com/problems/bitwise-xor-of-all-pairings/

public class BitwiseXOROfAllPairings {
    public static void main(String[] args) {
        int[] nums1 = {2,1,3};
        int[] nums2 = {10,2,5,0};

        System.out.println(xorAllNums(nums1, nums2));
    }

    public static int xorAllNums(int[] nums1, int[] nums2) {
        if ((nums1.length & 1) == 0 && (nums2.length & 1) == 0)  return 0;

        int count = 0;
        if ((nums1.length & 1) == 1) for (int i : nums2) count ^= i;
        if ((nums2.length & 1) == 1) for (int i : nums1) count ^= i;

        return count;
    }
}
