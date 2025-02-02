package Graph;

import java.util.LinkedList;
import java.util.Queue;

// https://www.geeksforgeeks.org/problems/knight-walk4521/1
public class KnightWalk {
    private final static int[][] directions = {{2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}};

    public static void main(String[] args) {
        int[] source = {4, 5};
        int[] target = {1, 1};
        int N = 6;

        System.out.println(minStepToReachTarget(source, target, N));
    }

    public static int minStepToReachTarget(int[] KnightPos, int[] TargetPos, int N) {
        boolean[][] isVisited = new boolean[N][N];
        Queue<int[]> queue = new LinkedList<>();
        int level = 0;
        queue.add(KnightPos);
        isVisited[KnightPos[0]-1][KnightPos[1]-1] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();

                if (pos[0] == TargetPos[0] && pos[1] == TargetPos[1]) return level;

                for (int[] dir : directions) {
                    int x = pos[0] + dir[0];
                    int y = pos[1] + dir[1];

                    if (isValid(x, y, N) && !isVisited[x-1][y-1]) {
                        queue.add(new int[] {x, y});
                        isVisited[x-1][y-1] = true;
                    }
                }
            }

            level++;
        }

        return -1;
    }

    private static boolean isValid(int i, int j, int N) {
        return i >= 1 && j >= 1 && i <= N && j <= N;
    }
}
