package Recursion$Backtracking;

// problem statement: https://leetcode.com/problems/combination-sum-ii/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public static void main(String[] args) {
        int[] arr = {10,1,2,7,6,1,5};
        int target = 8;
        var result = combinationSum2(arr, target);
        System.out.println(result);
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, new ArrayList<>(), result, 0);
        return result;
    }

    private static void helper(int[] candidates, int target, List<Integer> temp, List<List<Integer>> result, int index) {
        if (target <= 0) {
            if (target == 0) result.add(new ArrayList<>(temp));

            return;
        }

        Integer lastEle = null;

        for (int i = index; i < candidates.length; i++) {
            if (lastEle != null && lastEle == candidates[i]) continue;
            lastEle = candidates[i];
            temp.add(candidates[i]);
            helper(candidates, target - candidates[i], temp, result, i+1);
            temp.remove(temp.size()-1);
        }
    }
}
