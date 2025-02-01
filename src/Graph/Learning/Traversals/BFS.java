package Graph.Learning.Traversals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph
public class BFS {

    // V is number of vertices
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] isVisited = new boolean[V];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        isVisited[0] = true;
        result.add(0);

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int node = queue.poll();

                for (int j = 0; j < adj.get(node).size(); j++) {
                    int n = adj.get(node).get(j);
                    if (!isVisited[n]) {
                        isVisited[n] = true;
                        queue.add(n);
                        result.add(n);
                    }
                }
            }
        }

        return result;
    }
}
