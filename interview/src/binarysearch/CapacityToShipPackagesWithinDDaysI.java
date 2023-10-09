/**
 * https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/
 *
 * Time Complexity: O(answer - max) * O(N)
 * Space Complexity: O(1)
 * */
package binarysearch;

public class CapacityToShipPackagesWithinDDaysI {

    private boolean canShipWithCapacity(int[] weights, int n, int maxCapacity, int totalDays) {
        // days required to ship
        int days = 0;
        // track the current capacity
        int capacity = 0;
        for (int i = 0; i < weights.length; ++i) {
            capacity += weights[i];

            if (capacity >= maxCapacity) {
                if (capacity == maxCapacity) {
                    capacity = 0;
                } else {
                    capacity = weights[i];
                }
                ++days;
            }
            if (n - i == totalDays - days) {
                return true;
            }
        }
        if (capacity != 0) {
            ++days;
        }
        return days == totalDays;
    }

    private int shipWithinDays(int[] weights, int days) {
        // base case
        if (days == 1) { // if we need to ship all weights in one day : we need a ship with capacity total of weights
            int sum = 0;
            for (int weight : weights) {
                sum += weight;
            }
            return sum;
        }
        // max. weight out of all weights
        int maxWeight = Integer.MIN_VALUE;
        for (int weight : weights) {
            maxWeight = Math.max(maxWeight, weight);
        }
        // we need a ship with capacity atleast of maxWeight
        // now check if this capacity is enough to ship all the weights
        // if not : increase maxCapacity and check again
        int m = maxWeight;
        while (true) {
            if (canShipWithCapacity(weights, weights.length, m, days)) {
                return m;
            }
            ++m;
        }
    }

    public static void main(String[] args) {
        int weights[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, days = 5;
        System.out.println(new CapacityToShipPackagesWithinDDaysI().shipWithinDays(weights, days));
    }
}
