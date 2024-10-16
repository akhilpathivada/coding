/**
 * https://leetcode.com/problems/non-overlapping-intervals/description/
 *
 * Time Complexity: O(n * log(n))
 * Space Complexity: O(n)
 *
 * */
package greedy.intervals;

import java.util.Arrays;

public class NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]); // Sort intervals by their end time
        int end = intervals[0][1]; // Initialize with the end of the first interval
        int count = 0; // To count overlapping intervals
        for (int i = 1; i < intervals.length; ++i) {
            if (intervals[i][0] < end) { // If the current interval overlaps with the previous one, increment the count
                ++count;
            } else {
                end = intervals[i][1]; // Update the end time to the current interval's end time
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println(new NonOverlappingIntervals().eraseOverlapIntervals(intervals));
    }
}
