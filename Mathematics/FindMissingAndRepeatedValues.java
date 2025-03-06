package Mathematics;

import java.util.HashMap;
import java.util.HashSet;

public class FindMissingAndRepeatedValues {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int matSum = 0;

        int repeatingValue = -1;
        HashSet<Integer> set = new HashSet<>();
        for (int[] row : grid) {
            for (int col : row) {
                if (set.contains(col)) repeatingValue = col;
                else set.add(col);

                matSum += col;
            }
        }

        int idealSum = ((n*n) * ((n*n) + 1))/2;
        int sumAfterRemovingRepeatingValue = matSum - repeatingValue;
        int missingValue = idealSum - sumAfterRemovingRepeatingValue;

        return new int[] {repeatingValue, missingValue};
    }
}
