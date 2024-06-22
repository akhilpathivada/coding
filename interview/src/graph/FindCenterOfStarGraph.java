/**
 * author: akhilpathivada
 * time: 22/06/24 17:50
 *
 * https://leetcode.com/problems/find-center-of-star-graph/description/
 *
 */
package graph;

public class FindCenterOfStarGraph {

    private int findCenter(int[][] edges) {
        return edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1] ? edges[0][0] : edges[0][1];
    }

    public static void main(String[] args) {
        int[][] edges = {{1, 2}, {2, 3}, {4, 2}};
        System.out.println(new FindCenterOfStarGraph().findCenter(edges));
    }
}
