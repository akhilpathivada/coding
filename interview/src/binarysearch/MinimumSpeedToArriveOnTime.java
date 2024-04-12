/**
 * Date 11/04/24
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/minimum-speed-to-arrive-on-time/description/
 */
package binarysearch;

import java.util.Map;

public class MinimumSpeedToArriveOnTime {

    private boolean canArriveOnTime(int[] dist, double expectedArrivalTime, double speed) {
        int n = dist.length;
        double timeTakenForArrival = 0.0;
        for (int i = 0; i < n - 1; ++i) {
            timeTakenForArrival += Math.ceil((double) dist[i] / speed);
        }
        timeTakenForArrival += (double) dist[n - 1] / speed;
        return timeTakenForArrival <= expectedArrivalTime;
    }

    private int minSpeedOnTime(int[] dist, double hour) {
        // min. speed required to arrive on time
        int low = 1;
        // max. speed limit
        int high = (int) 1e7;
        // result
        int minSpeed = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canArriveOnTime(dist, hour, mid)) {
                minSpeed = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return minSpeed;
    }

    public static void main(String[] args) {
        int[] dist = {1, 3, 2};
        double hour = 2.7;
        System.out.println(new MinimumSpeedToArriveOnTime().minSpeedOnTime(dist, hour));
    }
}
