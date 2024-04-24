package graph.topological;

import java.util.*;

/**
 * Date 24/04/24
 * Time 09:18
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/largest-color-value-in-a-directed-graph/description/
 *
 */
public class LargestColorValueInADirectedGraph {

    public int largestPathValue(String colors, int[][] edges) {
        final int n = colors.length();
        final List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; ++i) {
            graph[i] = new ArrayList<>();
        }
        final int[] indegree = new int[n];
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            indegree[edge[1]]++;
        }
        // applying kahn's algorithm
        Queue<Integer> queue = new LinkedList<>();
        final int[][] count = new int[n][26];
        for (int i = 0; i < n; ++i) {
            if (indegree[i] == 0) {
                queue.add(i);
                count[i][colors.charAt(i) - 'a']++;
            }
        }
        int nodesSeen = 0;
        int result = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            ++nodesSeen;
            result = Math.max(result, Arrays.stream(count[node]).max().getAsInt());
            for (int neighbor : graph[node]) {
                // by traversing through which color to this node: will give the max. value
                for (int i = 0; i < 26; ++i) {
                    count[neighbor][i] = Math.max(count[neighbor][i], count[node][i]
                            + (i == colors.charAt(neighbor) - 'a' ? 1 : 0));
                }
                if (--indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        return nodesSeen != n ? -1 : result;
    }

    public static void main(String[] args) {
        String colors = "iiiiii";
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 5}};
        System.out.println(new LargestColorValueInADirectedGraph().largestPathValue(colors, edges));
    }
}
