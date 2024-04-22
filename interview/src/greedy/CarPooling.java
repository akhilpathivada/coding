package greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Date 20/04/24
 * Time 06:03
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/car-pooling/description/
 *
 *
 */
public class CarPooling {

    private boolean carPooling(int[][] trips, int capacity) {
        // sort based on 'start' positions
        Arrays.sort(trips, (a, b) -> a[1] - b[1]);
        // store based on 'end' positions
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        int seatsOccupied = 0;
        for (int[] trip : trips) {
            // remove the completed trips
            while (!minHeap.isEmpty() && minHeap.peek()[2] <= trip[1]) {
                seatsOccupied -= minHeap.poll()[0];
            }
            seatsOccupied += trip[0];
            if (seatsOccupied > capacity) {
                return false;
            }
            minHeap.offer(trip);
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] trips = {{2, 1, 5}, {3, 3, 7}};
        int capacity = 5;
        System.out.println(new CarPooling().carPooling(trips, capacity));
    }
}
