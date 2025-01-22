package Graph.Learning.ConnectedComponent;

// https://leetcode.com/problems/number-of-islands
public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };

        System.out.println(numIslands(grid));
    }

    private static final int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    public static int numIslands(char[][] grid) {
        int result = 0;

        int n = grid.length;
        int m = grid[0].length;


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    dfs(grid, n, m, i, j);
                }
            }
        }
        return result;
    }

    private static void dfs(char[][] mat, int n, int m, int x, int y) {
        if (!isValid(x, y, n, m) || mat[x][y] == '0') return;

        mat[x][y] = '0';

        for (int[] dir : directions)
            dfs(mat, n, m, x + dir[0], y + dir[1]);
    }

    private static boolean isValid(int x, int y, int n, int m) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }
}
