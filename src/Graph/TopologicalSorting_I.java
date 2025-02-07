package Graph;

import java.util.*;

//  https://www.geeksforgeeks.org/problems/topological-sort/1
public class TopologicalSorting_I {
    public static void main(String[] args) {
        var arr = new int[][] {{}, {3}, {3}, {}, {0,1}, {0,2}};
        var adj = ConvertToList(arr);
        System.out.println(topologicalSort(adj));
    }

    /************************* Topological sorting solved by counting inDegrees *************************/

    private static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        int[] inDegrees = new int[adj.size()];
        for (var li : adj) {
            for (var child : li) {
                inDegrees[child] += 1;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) queue.add(i);
        }

        ArrayList<Integer> sortedList = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int pop = queue.poll();
                sortedList.add(pop);

                // traversing its child
                for (int j = 0; j < adj.get(pop).size(); j++) {
                    int child = adj.get(pop).get(j);
                    inDegrees[child] -= 1;

                    // if any child inDegrees became 0 then pushing it into queue
                    if (inDegrees[child] == 0) queue.add(child);
                }
            }
        }

        return sortedList;
    }

    private static ArrayList<ArrayList<Integer>> ConvertToList(int[][] arr) {
        var result = new ArrayList<ArrayList<Integer>>();

        for (int[] num : arr) {
            ArrayList<Integer> aux = new ArrayList<>();
            for (int n : num) {
                aux.add(n);
            }

            result.add(aux);
        }

        return result;
    }
}
