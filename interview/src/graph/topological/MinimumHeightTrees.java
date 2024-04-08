/**
 * Date 08/04/24
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/minimum-height-trees/description/
 *
 *
 */
package graph.topological;

import java.util.*;

public class MinimumHeightTrees {

    private Map<Integer, List<Integer>> createGraph(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], list -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], list -> new ArrayList<>()).add(edge[0]);
        }
        return graph;
    }

    private List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // using KAHN's Algorithm
        // store the roots of MHTs
        List<Integer> result = new ArrayList<>();
        // create a graph in form of adjacency list
        Map<Integer, List<Integer>> graph = createGraph(n, edges);
        // store in-degree of a vertex
        int[] indegree = new int[n];
        // iterate over the graph and compute the in-degree of each node
        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            for (int neighbor : entry.getValue()) {
                indegree[neighbor]++;
            }
        }
        // queue to store vertices with indegree ==  0
        Queue<Integer> queue = new LinkedList<>();
        // insert all nodes of in-degree == 1
        for (int i = 0; i < n; ++i) {
            if (indegree[i] == 1) {
                queue.add(i);
            }
        }
        int visitedNodesCount = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            visitedNodesCount += size;
            for (int i = 0; i < size; ++i) {
                int node = queue.poll();
                // if visitedNodesCount == n, add the id of node into the resulting list
                if (visitedNodesCount == n) {
                    result.add(node);
                }
                for (int neighbor : graph.get(node)) {
                    if (indegree[neighbor] != 1) {
                        indegree[neighbor]--;
                        // if in-degree of a node equals to 1,
                        // it means this node has already been added into the resulting list
                        if (indegree[neighbor] == 1) {
                            queue.add(neighbor);
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] edges = {{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}};
        int n = 6;
        System.out.println(new MinimumHeightTrees().findMinHeightTrees(n, edges));
    }
}
