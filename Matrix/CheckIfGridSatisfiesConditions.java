package Matrix;

// 3142. https://leetcode.com/problems/check-if-grid-satisfies-conditions/
public class CheckIfGridSatisfiesConditions {
    public boolean satisfiesConditions(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if ((i+1) < grid.length && grid[i+1][j] != grid[i][j]) return false;
                if ((j+1) < grid[0].length && grid[i][j] == grid[i][j + 1]) return false;
            }
        }

        return true;
    }
}
