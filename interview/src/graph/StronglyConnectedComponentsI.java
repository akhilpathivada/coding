/**
 * https://www.geeksforgeeks.org/strongly-connected-components/
 *
 * Time Complexity: O(N ^ 3)
 * Space Complexity: O(N)
 * */
package graph;

import java.util.ArrayList;
import java.util.List;

public class StronglyConnectedComponentsI {

    // tells whether there is path from source to destination
    private boolean isHavingPath(GraphNode[] graph, int source, int destination) {
        return false;
    }

    // return all the strongly connected components
    private List<List<Integer>> findSCC(GraphNode[] graph, int n) {
        // stores all the SCC
        List<List<Integer>> result = new ArrayList<>();

        // stores whether a vertex is part of any SCC
        List<Integer> isSCC = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) {
            // assume no vertex is part of any SCC
            isSCC.add(0);
        }
        // traversing all the vertices
        for (int i = 0; i < n; ++i) {
            // if a vertex is not part of any SCC
            // insert it into a new SCC list and check
            // for the other vertices that can be part of this scc
            if (isSCC.get(i) == 0) {
                List<Integer> scc = new ArrayList<>();
                scc.add(i);
                for (int j = i + 1; j < n; ++j) {
                    if (isSCC.get(j) == 0 && isHavingPath(graph, i, j) && isHavingPath(graph, j, i)) {
                        scc.add(j);
                    }
                }
                result.add(scc);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        GraphNode[] graph = new GraphNode[5];
        graph[0] = new GraphNode(0);
        graph[1] = new GraphNode(1);
        graph[2] = new GraphNode(2);
        graph[3] = new GraphNode(3);
        graph[4] = new GraphNode(4);

        graph[0].addEdge(graph[2]);
        graph[1].addEdge(graph[0]);
        graph[2].addEdge(graph[1]);
        graph[0].addEdge(graph[3]);
        graph[3].addEdge(graph[4]);

        System.out.println(new StronglyConnectedComponentsI().findSCC(graph, graph.length));
    }
}
