/**
 * https://leetcode.com/problems/is-graph-bipartite/description/
 *
 * Time Complexity: O(V + E)
 * Space Complexity: O(V)
 * */
package graph;

import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {

    private boolean bfs(int[][] graph, int[] color, int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        color[node] = 1;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int _node : graph[current]) {
                // not bipartite
                if (color[_node] == color[current]) {
                    return false;
                }
                // not colored yet
                if (color[_node] == 0) {
                    color[_node] = color[current] == 2 ? 1 : 2;
                    queue.offer(_node);
                }
            }
        }
        return true;
    }

    private boolean isBipartite(int[][] graph) {
        // in java, by default elements in integer array has all 0s.
        // 0 -> not colored yet
        // 1 -> white
        // 2 -> black
        int[] color = new int[graph.length];
        for (int i = 0; i < graph.length; ++i) {
            if (color[i] == 0 && !bfs(graph, color, i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] graph = { { 1, 2, 3 }, { 0, 2 }, { 0, 1, 3 }, { 0, 2 } };
        System.out.println(new BipartiteGraph().isBipartite(graph));
    }
}
