/**
 * @author akhilpathivada
 * <p>
 * date : 02/04/24
 * time: 19:49
 *
 * Time Complexity: O(n logn) + O(n), where O(n logn) is for sorting
 * Space Complexity: O(n) -> sorting
 */
package greedy.intervals;

import java.util.Arrays;

public class MinimumNumberOfArrowsToBurstBalloons {

    private int findMinArrowShots(int[][] points) {
        int n = points.length;
        // base case
        if (n == 0) {
            return 0;
        }
        // sort points in ascending based on 'x-start' co-ordinate
        Arrays.sort(points, (x1, x2) -> Integer.compare(x1[0], x2[0]));
        int[] previousBalloon = points[0];
        int numberOfArrowsNeeded = n;
        for (int j = 1; j < n; ++j) {
            int[] currentBalloon = points[j];
            // if balloons overlapping : 1 arrow would be enough to burst both
            if (currentBalloon[0] <= previousBalloon[1]) {
                --numberOfArrowsNeeded;
                previousBalloon = new int[] { previousBalloon[0], Math.min(currentBalloon[1], previousBalloon[1]) };
            } else {
                previousBalloon = currentBalloon;
            }
        }
        return numberOfArrowsNeeded;
    }

    public static void main(String[] args) {
        int[][] points = { { 10, 16 }, { 2, 8 }, { 1, 6 }, { 7, 12 } };
        System.out.println(new MinimumNumberOfArrowsToBurstBalloons().findMinArrowShots(points));
    }
}
