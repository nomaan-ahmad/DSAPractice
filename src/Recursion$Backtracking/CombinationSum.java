package Recursion$Backtracking;

import java.util.ArrayList;
import java.util.List;

// problem statement: https://leetcode.com/problems/combination-sum/
public class CombinationSum {
    public static void main(String[] args) {
        int[] nums = {2,3,5};
        int target = 8;

        System.out.println(combinationSum(nums, target));
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, candidates, target, new ArrayList<>(), 0);
        return result;
    }

    private static void helper(List<List<Integer>> result, int[] candidates, int target, List<Integer> temp, int index) {
        if (target <= 0) {
            if (target == 0)
                result.add(new ArrayList<>(temp));

            return;
        }

        for (int i = index; i < candidates.length; i++) {
            temp.add(candidates[i]);
            helper(result, candidates, target - candidates[i], temp, i);
            temp.remove(temp.size()-1);
        }
    }
}
