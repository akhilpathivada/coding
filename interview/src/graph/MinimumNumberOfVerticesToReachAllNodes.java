/**
 * author: akhilpathivada
 * time: 23/06/24 17:44
 *
 * https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/description/
 *
 */
package graph;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MinimumNumberOfVerticesToReachAllNodes {

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        final int[] indegree = new int[n];
        edges.forEach(edge -> indegree[edge.get(1)]++);
        return IntStream.range(0, n).filter(i -> indegree[i] == 0).boxed().collect(Collectors.toList());
    }

    public static void main(String[] args) {
//        int n = 6;
//        int[][] edges = {{0, 1}, {0, 2}, {2, 5}, {3, 4}, {4, 2}};
//        System.out.println(new MinimumNumberOfVerticesToReachAllNodes().findSmallestSetOfVertices(n, edges));
    }
}
