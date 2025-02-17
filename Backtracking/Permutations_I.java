package Backtracking;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/permutations/description/
public class Permutations_I {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        for (int i : nums) arr.add(i);

        recurse(result, arr, 0);
        return result;
    }

    private static void recurse(List<List<Integer>> result, List<Integer> nums, int idx) {
        if (idx == nums.size()) {
            result.add(new ArrayList<>(nums));
            return;
        }

        for (int i = idx; i < nums.size(); i++) {
            int temp = nums.get(idx);
            nums.set(idx, nums.get(i));
            nums.set(i, temp);

            recurse(result, nums, idx+1);

            temp = nums.get(idx);
            nums.set(idx, nums.get(i));
            nums.set(i, temp);
        }
    }
}
