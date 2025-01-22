package Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/map-of-highest-peak
public class MapOfHighestPeak {
    public static void main(String[] args) {
        int[][] mat = {{0,0,1}, {1,0,0}, {0,0,0}};
        var result = highestPeak(mat);

        for (int[] r : result)
            System.out.println(Arrays.toString(r));
    }


/******************************************** Solved using BFS ************************************************/
    private static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int[][] highestPeak(int[][] isWater) {
        int n = isWater.length;
        int m = isWater[0].length;

        Queue<Pair> queue = new LinkedList<>();
        boolean[][] isVisited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isWater[i][j] == 1) {
                    queue.add(new Pair(i, j));
                    isVisited[i][j] = true;
                }
            }
        }

        int level = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;

            for (int i = 0; i < size; i++) {
                Pair p = queue.poll();

                isWater[p.x][p.y] = level;
                //pushing its next neighbour into the queue

                //top
                if (isValidIndex(p.x, p.y-1, n, m) && !isVisited[p.x][p.y-1]) {
                    queue.add(new Pair(p.x, p.y-1));
                    isVisited[p.x][p.y-1] = true;
                }

                //bottom
                if (isValidIndex(p.x, p.y+1, n, m) && !isVisited[p.x][p.y+1]) {
                    queue.add(new Pair(p.x, p.y+1));
                    isVisited[p.x][p.y+1] = true;
                }

                //left
                if (isValidIndex(p.x-1, p.y, n, m) && !isVisited[p.x-1][p.y]) {
                    queue.add(new Pair(p.x-1, p.y));
                    isVisited[p.x-1][p.y] = true;
                }

                //right
                if (isValidIndex(p.x+1, p.y, n, m) && !isVisited[p.x+1][p.y]) {
                    queue.add(new Pair(p.x+1, p.y));
                    isVisited[p.x+1][p.y] = true;
                }
            }
        }

        return isWater;
    }

    private static boolean isValidIndex(int x, int y, int n, int m) {
        return (x >= 0 && x < n) && (y >= 0 && y < m);
    }
}
