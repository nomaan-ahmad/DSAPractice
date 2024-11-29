package Recursion$Backtracking;

import java.util.*;

// Problem statement: https://leetcode.com/problems/subsets/
public class Subsets {
    public static void main(String[] args) {
        var result = subsets(new int[] {1,2,3});
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generate(result, nums, 0, new ArrayList<>());
        return result;
    }

    private static void generate(List<List<Integer>> result, int[] arr, int index, List<Integer> temp) {
        result.add(new ArrayList<>(temp));
        if (index == arr.length) return;

        for (int i = index; i < arr.length; i++) {
            temp.add(arr[i]);
            generate(result, arr, i + 1, temp);
            temp.remove(temp.remove(temp.size()-1));
        }
    }
}
