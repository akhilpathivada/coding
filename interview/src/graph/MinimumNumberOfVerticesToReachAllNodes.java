/**
 * author: akhilpathivada
 * time: 23/06/24 17:44
 *
 * https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/description/
 *
 */
package graph;

import java.util.ArrayList;
import java.util.List;

public class MinimumNumberOfVerticesToReachAllNodes {

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        final int[] indegree = new int[n];
        final List<Integer> result = new ArrayList<>();
        for (List<Integer> edge : edges) {
            indegree[edge.get(1)]++;
        }
        for (int i = 0; i < n; ++i) {
            if (indegree[i] == 0) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
