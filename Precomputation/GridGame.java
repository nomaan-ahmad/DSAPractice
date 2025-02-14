package Precomputation;

// https://leetcode.com/problems/grid-game/description/
public class GridGame {
    public static void main(String[] args) {
        int[][] grid = {{20,3,20,17,2,12,15,17,4,15},{20,10,13,14,15,5,2,3,14,3}};
        System.out.println(gridGame(grid));
    }

    private static long gridGame(int[][] grid) {
        long result = Long.MAX_VALUE;
        long up = 0;

        for (int i = 0; i < grid[0].length; i++) {
            up += grid[0][i];
        }

        long down = 0;
        for (int i = 0; i < grid[0].length; i++) {
            up -= grid[0][i];

            if (result > down && result > up) {
                result = Math.max(down, up);
            }

            down += grid[1][i];
        }

        return result;
    }
}
