/**
 *
 * https://leetcode.com/problems/find-eventual-safe-states/description/
 *
 * Time Complexity: O(V + E)
 * Space Complexity: O(V + E)
 * */
package graph.topological;

import java.util.ArrayList;
import java.util.List;

public class FindEventualSafeStates {

    enum State {
        SAFE,
        UNSAFE
    }

    private boolean isSafe(int[][] graph, int node, State[] states) {
        // if we visited the unsafe node (aka)
        // means if we are into a cycle:  return false
        if (states[node] != null) {
            return states[node] == State.SAFE;
        }
        // always mark the current node as unsafe
        states[node] = State.UNSAFE;
        for (int _node : graph[node]) {
            if (!isSafe(graph, _node, states)) {
                return false;
            }
        }
        // the node is not in the cycle
        states[node] = State.SAFE;
        return true;
    }

    private List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer> result = new ArrayList<>(n);
        State[] states = new State[n];
        for (int i = 0; i < n; ++i) {
            // found safe node
            if (isSafe(graph, i, states)) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] graph = { { 1, 2 }, { 2, 3 }, { 5 }, { 0 }, { 5 }, {}, {} };
        System.out.println(new FindEventualSafeStates().eventualSafeNodes(graph));
    }
}
