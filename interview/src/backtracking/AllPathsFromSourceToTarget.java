package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllPathsFromSourceToTarget {

    private void backtrack(List<List<Integer>> result, List<Integer> path, int[][] graph, int node, int n) {
        // base case
        if (node >= n) {
            return;
        }
        // found node
        if (node == n - 1) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int _node : graph[node]) {
            path.add(_node);
            backtrack(result, path, graph, _node, n);
            path.remove(path.size() - 1);
        }
    }

    private List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(Arrays.asList(0)), graph, 0, graph.length);
        return result;
    }

    public static void main(String[] args) {
        int[][] graph = { { 1, 2 }, { 3 }, { 3 }, {} };
        System.out.println(new AllPathsFromSourceToTarget().allPathsSourceTarget(graph));
    }
}
