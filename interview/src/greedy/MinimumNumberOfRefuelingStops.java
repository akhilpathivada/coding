package greedy;

import java.util.PriorityQueue;

/**
 * Date 19/04/24
 * Time 19:38
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/minimum-number-of-refueling-stops/description/?envType=list&envId=55ac4kuc
 *
 * 
 */
public class MinimumNumberOfRefuelingStops {

    private int minRefuelStops(int target, int startFuel, int[][] stations) {
        int distanceCoveredSoFar = startFuel;
        int currentFuelingStation = 0;
        int stops = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        while (distanceCoveredSoFar < target) {
            // store the fuels in max heap for the stations we covered so far
            while (currentFuelingStation < stations.length
                    && stations[currentFuelingStation][0] <= distanceCoveredSoFar) {
                maxHeap.offer(stations[currentFuelingStation++][1]);
            }
            if (maxHeap.isEmpty()) {
                return -1;
            }
            distanceCoveredSoFar += maxHeap.poll();
            ++stops;
        }
        return stops;
    }

    public static void main(String[] args) {
        int target = 100, startFuel = 10;
        int[][] stations = {{10, 60}, {20, 30}, {30, 30}, {60, 40}};
        System.out.println(new MinimumNumberOfRefuelingStops().minRefuelStops(target, startFuel, stations));
    }
}
