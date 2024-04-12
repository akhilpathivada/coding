/**
 * Date 11/04/24
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/minimum-time-to-complete-trips/description/
 *
 *
 */
package binarysearch;

import java.util.Arrays;

public class MinimumTimeToCompleteTrips {

    private boolean canFinishAllTripsWithinDeadline(int[] time, int totalTrips, long deadline) {
        long tripsCompleted = 0;
        for (int t : time) {
            tripsCompleted += deadline / t;
        }
        return tripsCompleted >= totalTrips;
    }

    public long minimumTime(int[] time, int totalTrips) {
        int min = Arrays.stream(time).min().getAsInt();
        // min. time to complete the total trips
        long low = 1;
        // max. time to complete the total trips
        long high = (long) min * totalTrips;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (canFinishAllTripsWithinDeadline(time, totalTrips, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] time = {1, 2, 3};
        int totalTrips = 5;
        System.out.println(new MinimumTimeToCompleteTrips().minimumTime(time, totalTrips));
    }
}
