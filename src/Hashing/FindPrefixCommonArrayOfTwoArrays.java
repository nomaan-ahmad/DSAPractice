package Hashing;

import java.util.Arrays;
import java.util.HashSet;

// https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/
public class FindPrefixCommonArrayOfTwoArrays {
    public static void main(String[] args) {
        int[] A = {1,3,2,4};
        int[] B = {3,1,2,4};

        System.out.println(Arrays.toString(findThePrefixCommonArray_UsingHashSet(A, B)));
    }

    // Using HashSet
    public static int[] findThePrefixCommonArray_UsingHashSet(int[] A, int[] B) {
        int n = A.length;
        int[] result = new int[n];
        int count = 0;

        HashSet<Integer> ASet = new HashSet<>();
        HashSet<Integer> BSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            ASet.add(A[i]);
            BSet.add(B[i]);

            if (A[i] == B[i]) count++;
            else {
                if (ASet.contains(B[i])) count++;
                if (BSet.contains(A[i])) count++;
            }

            result[i] = count;
        }

        return result;
    }

    // Using Boolean Array
    public static int[] findThePrefixCommonArray_UsingTwoBooleanArray(int[] A, int[] B) {
        int n = A.length;
        int[] result = new int[n];
        int count = 0;

        boolean[] AMap = new boolean[n+1];
        boolean[] BMap = new boolean[n+1];

        for (int i = 0; i < n; i++) {
            AMap[A[i]] = true;
            BMap[B[i]] = true;

            if (A[i] == B[i]) count++;
            else {
                if (AMap[B[i]]) count++;
                if (BMap[A[i]]) count++;
            }

            result[i] = count;
        }

        return result;
    }

    // Optimized approach -- Using single Array to track
    public static int[] findThePrefixCommonArray_UsingSingleArray(int[] A, int[] B) {
        int n = A.length;
        int[] result = new int[n];
        int count = 0;

        int[] track = new int[n+1];

        for (int i = 0; i < n; i++) {
            if (++track[A[i]] == 2) count++;
            if (++track[B[i]] == 2) count++;

            result[i] = count;
        }

        return result;
    }
}
