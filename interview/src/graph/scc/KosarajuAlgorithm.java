/**
 *
 * https://www.geeksforgeeks.org/strongly-connected-components/
 * https://www.geeksforgeeks.org/connectivity-in-a-directed-graph/
 *
 * Time Complexity: O(V + E)
 * Space Complexity: O(V + E)
 * */
package graph.scc;

import graph.GraphNode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

public class KosarajuAlgorithm {

    private void dfs(GraphNode node, Set<Integer> visited, Stack<Integer> stack) {
        visited.add(node.label);
        for (GraphNode _node : node.neighbours) {
            if (!visited.contains(_node.label)) {
                dfs(_node, visited, stack);
            }
        }
        stack.push(node.label);
    }

    private void dfs2(GraphNode node, Set<Integer> visited) {
        visited.add(node.label);
        for (GraphNode _node : node.neighbours) {
            if (!visited.contains(_node.label)) {
                dfs2(_node, visited);
            }
        }
    }

    private GraphNode[] getTranspose(GraphNode[] graph, int n) {
        GraphNode[] transpose = new GraphNode[n];
        // create all the nodes
        for (int i = 0; i < n; ++i) {
            transpose[i] = new GraphNode(i);
        }
        for (int i = 0; i < n; ++i) {
            // Recur for all the vertices adjacent to this vertex
            Iterator<GraphNode> iterator = graph[i].neighbours.listIterator();
            while (iterator.hasNext()) {
                transpose[iterator.next().label].addEdge(transpose[i]);
            }
        }
        return transpose;
    }

    private int findSCC(GraphNode[] graph, int n) {
        Set<Integer> visited = new HashSet<>(n);
        Stack<Integer> stack = new Stack<>();
        // Step 1: Do DFS traversal starting from first vertex
        for (int i = 0; i < n; ++i) {
            if (!visited.contains(graph[i].label)) {
                dfs(graph[i], visited, stack);
            }
        }
        // Step 2: Create a reversed graph
        GraphNode[] transpose = getTranspose(graph, n);
        // Step 3: Mark all the vertices as not visited (For second DFS)
        visited = new HashSet<>();
        // Step 4: Do DFS for reversed graph starting from first vertex.
        // Starting Vertex must be same starting point of first DFS
        int scc = 0;
        while (!stack.isEmpty()) {
            int vertex = stack.pop();
            if (!visited.contains(vertex)) {
                ++scc;
                dfs2(transpose[vertex], visited);
            }
        }
        return scc;
    }

    private boolean isSCC(GraphNode[] graph, int n) {
        Set<Integer> visited = new HashSet<>(n);
        // Step 1: Do DFS traversal starting from first vertex
        dfs2(graph[0], visited);
        // Step 2: If DFS traversal doesn't visit all vertices, then return false.
        for (int i = 0; i < n; ++i) {
            if (!visited.contains(graph[i].label)) {
                return false;
            }
        }
        // Step 3: Create a reversed graph
        GraphNode[] transpose = getTranspose(graph, n);
        // Step 4: Mark all the vertices as not visited (For second DFS)
        visited = new HashSet<>();
        // Step 5: Do DFS for reversed graph starting from first vertex.
        // Starting Vertex must be same starting point of first DFS
        dfs2(transpose[0], visited);
        // Step 6: If DFS traversal doesn't visit all vertices, then return false.
        for (int i = 0; i < n; ++i) {
            if (!visited.contains(graph[i].label)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 8;
        // create graph with 'n' nodes
        GraphNode[] graph = new GraphNode[n];
        graph[0] = new GraphNode(0);
        graph[1] = new GraphNode(1);
        graph[2] = new GraphNode(2);
        graph[3] = new GraphNode(3);
        graph[4] = new GraphNode(4);
        graph[5] = new GraphNode(5);
        graph[6] = new GraphNode(6);
        graph[7] = new GraphNode(7);
        // add edges
        graph[0].addEdge(graph[1]);
        graph[1].addEdge(graph[2]);
        graph[2].addEdge(graph[0]);
        graph[2].addEdge(graph[3]);
        graph[3].addEdge(graph[4]);
        graph[4].addEdge(graph[5]);
        graph[4].addEdge(graph[7]);
        graph[5].addEdge(graph[6]);
        graph[6].addEdge(graph[4]);
        graph[6].addEdge(graph[7]);
        System.out.println("The number of strongly connected components is: " + new KosarajuAlgorithm().findSCC(graph, n));

        n = 5;
        GraphNode[] graph2 = new GraphNode[n];
        // create graph with 'n' nodes
        graph2[0] = new GraphNode(0);
        graph2[1] = new GraphNode(1);
        graph2[2] = new GraphNode(2);
        graph2[3] = new GraphNode(3);
        graph2[4] = new GraphNode(4);
        // add edges
        graph2[0].addEdge(graph2[1]);
        graph2[1].addEdge(graph2[2]);
        graph2[2].addEdge(graph2[3]);
        graph2[3].addEdge(graph2[0]);
        graph2[2].addEdge(graph2[4]);
        graph2[4].addEdge(graph2[2]);
        System.out.println("The given graph is SCC: " + new KosarajuAlgorithm().isSCC(graph2, n));
        System.out.println("The number of strongly connected components is: " + new KosarajuAlgorithm().findSCC(graph2, n));
    }
}
