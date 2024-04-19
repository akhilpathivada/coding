/**
 * Date 11/05/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/k-closest-points-to-origin/
 *
 * Time Complexity : O(N * log(N)) -> for sorting
 * Space Complexity : O(N) -> space needed for sorting
 */
package greedy;

import java.util.*;

public class KClosestPointsToOrigin {
        private int[][] kClosest2(int[][] points, int k) {
                Arrays.sort(points, Comparator.comparing(p -> p[0] * p[0] + p[1] * p[1]));
                return Arrays.copyOfRange(points, 0, k);
        }

        private int[][] kClosest(int[][] points, int k) {
                PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>((p1, p2)
                        -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);
                for (int[] p : points) {
                        maxHeap.offer(p);
                        if (maxHeap.size() > k) {
                                maxHeap.poll();
                        }
                }
                int[][] result = new int[k][2];
                while (k-- > 0) {
                        result[k] = maxHeap.poll();
                }
                return result;
        }

        public static void main(String[] args) {
                int[][] points = { { 1, 3 }, { -2, 2 } };
                int k = 1;
                System.out.println(Arrays.deepToString(new KClosestPointsToOrigin().kClosest(points, k)));
        }
}
