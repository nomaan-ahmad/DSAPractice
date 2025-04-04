package DynamicProgramming;

import java.util.Arrays;

// https://leetcode.com/problems/min-cost-climbing-stairs/description/
public class MinCostClimbingStairs {
    public static int minCostClimbingStairs(int[] cost) {
        int[] memo = new int[cost.length+1];
        Arrays.fill(memo, -1);
        recurse(cost, memo, 0);
        return Math.min(memo[0], memo[1]);
    }

    private static int recurse(int[] cost, int[] memo, int index) {
        if (index == cost.length) return 0;
        if (index > cost.length) return Integer.MAX_VALUE;
        if (memo[index] != -1) return memo[index];

        var one = recurse(cost, memo, index+1);
        var two = recurse(cost, memo, index+2);

        var min = cost[index] + Math.min(one, two);

        memo[index] = min;

        return min;
    }

    public static void main(String[] args) {
        int[] arr = {10,15,20};
        System.out.println(minCostClimbingStairs(arr));
    }
}
