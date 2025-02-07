package Hashing;

import java.util.HashMap;

public class TupleWithSameProduct {
    public static void main(String[] args) {
        int[] nums = {1,2,4,5,10};
        System.out.println(tupleSameProduct(nums));
    }

    public static int tupleSameProduct(int[] nums) {
        int count = 0;

        HashMap<Integer, Integer> frequency = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int prod = nums[i] * nums[j];

                frequency.put(prod, frequency.getOrDefault(prod, 0) + 1);
            }
        }

        for (var freq : frequency.keySet()) {
            if (freq > 1) {
                var numOfPairs = frequency.get(freq);
                int multiple = (numOfPairs * (numOfPairs - 1)) / 2;

                count += 8 * multiple;
            }
        }

        return count;
    }
}
