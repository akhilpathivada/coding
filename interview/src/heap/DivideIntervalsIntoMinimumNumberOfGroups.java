/**
 * author: akhilpathivada
 * time: 12/10/24 09:04
 *
 * https://leetcode.com/problems/divide-intervals-into-minimum-number-of-groups/
 *
 */
package greedy;

import java.util.Arrays;

public class DivideIntervalsIntoMinimumNumberOfGroups {

    private int minGroups(int[][] intervals) {
        final int n = intervals.length;
        final int[] startTimes = new int[n];
        final int[] endTimes = new int[n];
        for (int i = 0; i < n; ++i) {
            startTimes[i] = intervals[i][0];
            endTimes[i] = intervals[i][1];
        }
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);
        System.out.println(Arrays.toString(startTimes));
        System.out.println(Arrays.toString(endTimes));

        return 1;
    }

    public static void main(String[] args) {
        int[][] intervals = {{5, 10}, {6, 8}, {1, 5}, {2, 3}, {1, 10}};
        System.out.println(new DivideIntervalsIntoMinimumNumberOfGroups().minGroups(intervals));
    }
}
