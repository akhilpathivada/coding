/**
 *
 * https://leetcode.com/problems/evaluate-division/description/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * */
package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluateDivision {

    private void dfs(final String node, final String dest, final Map<String, Map<String, Double>> graph,
                     final Set<String> visited, final double[] ans, final double result) {
        // base case
        if (visited.contains(node)) {
            return;
        }
        visited.add(node);
        // capture the result
        if (node.equals(dest)) {
            ans[0] = result;
            return;
        }
        for (Map.Entry<String, Double> entry : graph.get(node).entrySet()) {
            String adjacentNode = entry.getKey();
            double val = entry.getValue();
            dfs(adjacentNode, dest, graph, visited, ans, result * val);
        }
    }

    private double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        final Map<String, Map<String, Double>> graph = new HashMap<>();
        // create the graph
        for (int i = 0; i < equations.size(); ++i) {
            String dividend = equations.get(i).get(0);
            String divisor = equations.get(i).get(1);
            graph.computeIfAbsent(dividend, m -> new HashMap<>()).put(divisor, values[i]);
            graph.computeIfAbsent(divisor, m -> new HashMap<>()).put(dividend, 1.0 / values[i]); // put inverse
        }
        final double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); ++i) {
            String dividend = queries.get(i).get(0);
            String divisor = queries.get(i).get(1);
            if (!graph.containsKey(dividend) || !graph.containsKey(divisor)) {
                results[i] = -1.0;
                continue;
            }
            Set<String> visited = new HashSet<>();
            double[] ans = {-1.0};
            dfs(dividend, divisor, graph, visited, ans, 1.0);
            results[i] = ans[0];
        }
        return results;
    }

    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a", "b"));
        equations.add(Arrays.asList("b", "c"));
        double[] values = { 2.0, 3.0 };
        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("b", "a"));
        queries.add(Arrays.asList("a", "e"));
        queries.add(Arrays.asList("a", "a"));
        queries.add(Arrays.asList("x", "x"));
        System.out.println(Arrays.toString(new EvaluateDivision().calcEquation(equations, values, queries)));
    }
}
