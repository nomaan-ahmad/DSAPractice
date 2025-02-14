package Heap;

import java.util.PriorityQueue;

// https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-ii/
public class MinimumOperationsToExceedThresholdValue_II {
    public static void main(String[] args) {
        int[] nums = {1,1,2,4,9};
        int k = 20;
        System.out.println(minOperations(nums, k));
    }

    public static int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int num : nums) {
            if (num <= k) pq.add((long)num);
        }

        int count = 0;

        while (pq.size() >= 2 && pq.peek() < k) {
            long first = pq.poll();
            long second = pq.poll();
            pq.add((first * 2) + second);

            count++;
        }

        return count;
    }
}
