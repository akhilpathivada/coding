/**
 * author: akhilpathivada
 * time: 11/06/24 17:43
 *
 * https://leetcode.com/problems/remove-covered-intervals/description/
 *
 */
package greedy.intervals;

import java.util.Arrays;

public class RemoveCoveredIntervals {

    private int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
        });
        int max = intervals[0][1];
        int result = 1;
        for (int[] interval : intervals) {
            if (interval[1] > max) {
                ++result;
                max = interval[1];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 4}, {3, 6}, {2, 8}};
        System.out.println(new RemoveCoveredIntervals().removeCoveredIntervals(intervals));
    }
}
