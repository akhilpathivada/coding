/**
 * https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/
 *
 * Time Complexity: O(log(answer - max) * N)
 * Space Complexity: O(1)
 * */
package binarysearch;

public class CapacityToShipPackagesWithinDDaysII {
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
        // compute the total weight
        int totalWeight = 0;
        for (int weight : weights) {
            maxWeight = Math.max(maxWeight, weight);
            totalWeight += weight;
        }
        // the capacity needed would be always exist between the maxWeight
        // and the total weight... using binary search
        int low = maxWeight;
        int high = totalWeight;
        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canShipWithCapacity(weights, weights.length, mid, days)) { // if we can ship with mid, check if
                // we can check with any lesser value
                result = mid;
                high = mid - 1;
            } else { // search for the minimum capacity on the right
                low = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int weights[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, days = 5;
        System.out.println(new CapacityToShipPackagesWithinDDaysII().shipWithinDays(weights, days));
    }
}
