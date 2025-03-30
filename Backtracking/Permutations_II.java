package Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// https://leetcode.com/problems/permutations-ii/
public class Permutations_II {
    public static void main(String[] args) {
        int[] nums = {1,1,2,3};

        System.out.println(permuteUnique(nums));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        dfs(result, nums, 0);

        return result;
    }

    private static void dfs(List<List<Integer>> result, int[] nums, int level) {
        if (level == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int i : nums) temp.add(i);
            result.add(temp);
            return;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = level; i < nums.length; i++) {

            if (!set.contains(nums[i])) {
                set.add(nums[i]);

                int temp = nums[i];
                nums[i] = nums[level];
                nums[level] = temp;

                dfs(result, nums, level+1);

                temp = nums[level];
                nums[level] = nums[i];
                nums[i] = temp;
            }
        }
    }
}
