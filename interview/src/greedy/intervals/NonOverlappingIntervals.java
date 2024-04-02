/**
 * https://leetcode.com/problems/non-overlapping-intervals/description/
 *
 * Time Complexity: O(N * log(N))
 * Space Complexity: O(N)
 *
 * */
package greedy.intervals;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {

    class Interval {
        int start;
        int end;

        Interval(int s, int f) {
            this.start = s;
            this.end = f;
        }
    }

    class myComparator implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            return a.end - b.end;
        }
    }

    public int eraseOverlapIntervals(int[][] intervals) {

        Interval[] arr = new Interval[intervals.length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Interval(intervals[i][0], intervals[i][1]);

        }
        Arrays.sort(arr, new myComparator());
        int end = arr[0].end;
        int count = 1;

        for (int i = 1; i < intervals.length; i++) {
            if (arr[i].start >= end) {
                end = arr[i].end;
                count++;
            }
        }
        return intervals.length - count;
    }

    public static void main(String[] args) {
        int[][] intervals = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };
        System.out.println(new NonOverlappingIntervals().eraseOverlapIntervals(intervals));
    }
}
