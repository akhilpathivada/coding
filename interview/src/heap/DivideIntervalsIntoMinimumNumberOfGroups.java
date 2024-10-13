/**
 * author: akhilpathivada
 * time: 12/10/24 09:04
 *
 * https://leetcode.com/problems/divide-intervals-into-minimum-number-of-groups/
 *
 */
package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class DivideIntervalsIntoMinimumNumberOfGroups {

    private int minGroups(int[][] intervals) {
        final PriorityQueue<Integer> groupEndTimes = new PriorityQueue<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]); // Sort intervals by their start times
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            if (!groupEndTimes.isEmpty() && start > groupEndTimes.peek()) { // If the earliest group's end time is
                // before the current interval's start, the interval can join the group, so remove the group's end time.
                groupEndTimes.poll();
            }
            groupEndTimes.offer(end); // Add the current interval's end time to the heap (new or existing group)
        }
        return groupEndTimes.size(); // The size of the heap indicates the number of groups required
    }

    public static void main(String[] args) {
        int[][] intervals = {{5, 10}, {6, 8}, {1, 5}, {2, 3}, {1, 10}};
        System.out.println(new DivideIntervalsIntoMinimumNumberOfGroups().minGroups(intervals));
    }
}
