/**
 * @author akhilpathivada
 * <p>
 * date : 02/04/24
 * time: 23:08
 *
 * https://leetcode.com/problems/insert-interval/description/
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
package greedy.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

    private int[][] merge(List<int[]> intervals) {
        List<int[]> mergedIntervals = new ArrayList<>();
        mergedIntervals.add(intervals.get(0));
        int i = 0;
        for (int j = 1; j < intervals.size(); ++j) {
            int[] prevInterval = intervals.get(i);
            int[] currentInterval = intervals.get(j);
            if (currentInterval[0] <= prevInterval[1]) {
                mergedIntervals.get(i)[1] = Math.max(prevInterval[1], currentInterval[1]);
            } else {
                mergedIntervals.add(currentInterval);
                ++i;
            }
        }
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }

    private int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> updatedIntervals = new ArrayList<>();
        // base case
        if (intervals.length == 0) {
            updatedIntervals.add(newInterval);
            return updatedIntervals.toArray(new int[1][]);
        }
        int i = 0;
        // iterate till we find the position and add the intervals which are lesser than newInterval
        while (i < n && intervals[i][1] < newInterval[0]) {
            updatedIntervals.add(intervals[i]);
            ++i;
        }
        if (i == n) { // if newInterval to be placed at end
            updatedIntervals.add(newInterval);
        } else { // if newInterval to be placed somewhere in the mid
            updatedIntervals.add(new int[] { Math.min(intervals[i][0], newInterval[0]), newInterval[1] });
        }
        // add the remaining intervals
        while (i < n) {
            updatedIntervals.add(intervals[i++]);
        }
        return merge(updatedIntervals);
    }

    public static void main(String[] args) {
        int[][] intervals = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
        int[] newInterval = { 4, 8 };
        System.out.println(Arrays.deepToString(new InsertInterval().insert(intervals, newInterval)));
    }
}
