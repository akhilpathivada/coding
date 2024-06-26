/**
 * author: akhilpathivada
 * time: 26/06/24 19:03
 *
 * https://leetcode.com/problems/node-with-highest-edge-score/
 *
 */
package hashing;

public class NodeWithHighestEdgeScore {

    private int edgeScore(int[] edges) {
        final int n = edges.length;
        final long[] scores = new long[n];
        for (int i = 0; i < n; ++i) {
            scores[edges[i]] += i;
        }
        int result = 0;
        for (int i = 0; i < n; ++i) {
            if (scores[i] > scores[result]) {
                result = i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] edges = {1, 0, 0, 0, 0, 7, 7, 5};
        System.out.println(new NodeWithHighestEdgeScore().edgeScore(edges));
    }
}
