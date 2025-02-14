package Recursion$Backtracking;

import java.util.ArrayList;

// https://www.geeksforgeeks.org/problems/subset-sums2234/1
public class SubsetSumGFG {
    public static void main(String[] args) {
        int[] arr = {2,3};

        var result = subsetSums(arr);

        System.out.println(result);
    }
    public static ArrayList<Integer> subsetSums(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        helper(arr, -1, result, 0);
        return result;
    }

    private static void helper(int[] arr, int idx, ArrayList<Integer> result, int sum) {
        if (idx == arr.length) return;

        result.add(sum);

        for (int i = idx+1; i < arr.length; i++) {
            helper(arr, i, result, sum + arr[i]);
        }
    }
}
