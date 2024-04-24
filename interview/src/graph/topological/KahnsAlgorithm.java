package graph.topological;

import java.util.*;

/**
 * Date 08/04/24
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/topological-sorting-indegree-based-solution/
 *
 * Time Complexity: O(V + E)
 * The outer for loop will be executed V number of times and the inner for loop will be executed E number of times.
 * Space Complexity: O(V)
 * The queue needs to store all the vertices of the graph. So the space required is O(V)
 *
 */
public class KahnsAlgorithm {

    private Map<Integer, List<Integer>> createGraph(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], list -> new ArrayList<>()).add(edge[1]);
        }
        return graph;
    }

    private List<Integer> topologicalSort(int n, int[][] edges) {
        // create a graph in form of adjacency list
        Map<Integer, List<Integer>> graph = createGraph(n, edges);
        // store in-degree of a vertex
        int[] indegree = new int[n];
        // iterate over the graph and compute the in-degree of each node
        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            for (int node : entry.getValue()) {
                indegree[node]++;
            }
        }
        // queue to store vertices with indegree ==  0
        Queue<Integer> queue = new LinkedList<>();
        // step-1: insert all nodes of in-degree == 0
        for (int i = 0; i < n; ++i) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        // step-2: store the topological sort of the graph
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);
            // step-3: decrease the in-degree of adjacent vertices as the
            // current node is in topological order
            for (int neighbor : graph.get(node)) {
                // step-4: if indegree becomes 0, push it to the queue
                if (--indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        // step-5: check for cycle
        if (result.size() != n) {
            System.out.println("Graph contains cycle!");
            return new ArrayList<>();
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] edges = {{0, 1}, {1, 2}, {3, 1}, {3, 2}};
        System.out.println(new KahnsAlgorithm().topologicalSort(n, edges));
    }
}
