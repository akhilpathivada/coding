/**
 * https://leetcode.com/problems/possible-bipartition/description/
 * */
package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class PossibleBipartition {

    private boolean bfs(List<List<Integer>> graph, int[] color, int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        color[node] = 1;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int _node : graph.get(current)) {
                // not bipartite
                if (color[_node] == color[current]) {
                    return false;
                }
                // not colored yet
                if (color[_node] == 0) {
                    color[_node] = color[current] == 2 ? 1 : 2;
                    queue.add(_node);
                }
            }
        }
        return true;
    }

    private boolean possibleBipartition(int[][] dislikes, int n) {
        // form a graph
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n + 1; i++)
            graph.add(new ArrayList<>());

        for (int[] dis : dislikes) {
            graph.get(dis[0]).add(dis[1]);
            graph.get(dis[1]).add(dis[0]);
        }
        // in java, by default elements in integer array has all 0s.
        // 0 -> not colored yet
        // 1 -> white
        // 2 -> black
        int[] color = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            if (color[i] == 0 && !bfs(graph, color, i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] dislikes = { { 1, 2 }, { 1, 3 }, { 2, 4 } };
        int n = 4;
        System.out.println(new PossibleBipartition().possibleBipartition(dislikes, n));
    }
}
