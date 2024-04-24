/**
 * Date 27/04/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/detect-cycle-in-a-graph/
 *
 * Time Complexity : O(V + E)
 * Space Complexity : O(V + E)
 */
package graph.cycle;

import graph.GraphNode;

public class DetectCycleInDirectedGraph {

        private boolean isCycleUtil(final GraphNode node, final boolean[] visited, final boolean[] pathVisited) {
                if (pathVisited[node.label]) {
                        return true;
                }
                if (visited[node.label]) {
                        return false;
                }
                // Mark the current node as visited and
                // part of recursion stack
                visited[node.label] = true;
                pathVisited[node.label] = true;
                for (GraphNode neighbour : node.neighbours) {
                        if (isCycleUtil(neighbour, visited, pathVisited)) {
                                return true;
                        }
                }
                pathVisited[node.label] = false;
                return false;
        }

        private boolean isCycle(GraphNode[] graph) {
                final int n = graph.length;
                // Mark all the vertices as not visited and
                // not part of recursion stack
                final boolean[] visited = new boolean[n];
                final boolean[] pathVisited = new boolean[n];
                for (GraphNode node : graph) {
                        if (isCycleUtil(node, visited, pathVisited)) {
                                return true;
                        }
                }
                return false;
        }

        public static void main(String[] args) {
                GraphNode[] graph = new GraphNode[4];
                graph[0] = new GraphNode(0);
                graph[1] = new GraphNode(1);
                graph[2] = new GraphNode(2);
                graph[3] = new GraphNode(3);
                graph[0].addEdge(graph[1]);
                graph[0].addEdge(graph[2]);
                graph[1].addEdge(graph[2]);
                graph[2].addEdge(graph[0]);
                graph[2].addEdge(graph[3]);
                graph[3].addEdge(graph[3]);
                System.out.println(new DetectCycleInDirectedGraph().isCycle(graph));
        }
}
