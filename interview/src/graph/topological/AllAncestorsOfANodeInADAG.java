package graph.topological;

import java.util.*;

/**
 * Date 24/04/24
 * Time 07:11
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/all-ancestors-of-a-node-in-a-directed-acyclic-graph/description/
 *
 */
public class AllAncestorsOfANodeInADAG {

    private List<List<Integer>> getAncestors(int n, int[][] edges) {
        final List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; ++i) {
            graph[i] = new ArrayList<>();
        }
        final int[] indegree = new int[n];
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            indegree[edge[1]]++;
        }
        final TreeSet<Integer>[] ancestors = new TreeSet[n];
        for (int i = 0; i < n; ++i) {
            ancestors[i] = new TreeSet<>();
        }
        // applying kahn's algorithm
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph[node]) {
                ancestors[neighbor].addAll(ancestors[node]);
                ancestors[neighbor].add(node);
                if (--indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        final List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            result.add(new ArrayList<>(ancestors[i]));
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 8;
        int[][] edgeList = {{0, 3}, {0, 4}, {1, 3}, {2, 4}, {2, 7}, {3, 5}, {3, 6}, {3, 7}, {4, 6}};
        System.out.println(new AllAncestorsOfANodeInADAG().getAncestors(n, edgeList));
    }
}
