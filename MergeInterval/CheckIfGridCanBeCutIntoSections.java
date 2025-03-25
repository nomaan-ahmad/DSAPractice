package MergeInterval;

import java.util.Arrays;

// https://leetcode.com/problems/check-if-grid-can-be-cut-into-sections
public class CheckIfGridCanBeCutIntoSections {
    public static void main(String[] args) {
        int n = 5;
        int[][] rectangles = {{1,0,5,2},{0,2,2,4},{3,2,5,3},{0,4,4,5}};

        System.out.println(checkValidCuts(n , rectangles));
    }

    public static boolean checkValidCuts(int n, int[][] rectangles) {
        return helper(rectangles, 0) || helper(rectangles, 1);
    }

    private static boolean helper(int[][] rectangles, int horizontal) {
        Arrays.sort(rectangles, (a, b) -> {
            if (a[horizontal] == b[horizontal]) return Integer.compare(a[horizontal+2], b[horizontal+2]);
            else return Integer.compare(a[horizontal], b[horizontal]);
        });

        int right = rectangles[0][horizontal+2];

        int count = 0;
        for (int i = 1; i < rectangles.length; i++) {

            if (count == 2) return true;

            int start = rectangles[i][horizontal];
            int end = rectangles[i][horizontal+2];

            if (start >= right) {
                count++;
                right = end;
            }else if (end > right) right = end;
        }

        return count == 2;
    }
}
