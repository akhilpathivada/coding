/**
 * @author akhilpathivada
 * <p>
 * date : 25/12/23
 * time: 11:29
 *
 * https://www.codingninjas.com/studio/problems/aggressive-cows_1082559
 *
 * Time Complexity:  O(N * log(max(arr[]) - min(arr[])))
 * Space Complexity: O(1)
 */
package binarysearch;

import java.util.Arrays;

public class AggressiveCows {

    private boolean canWePlaceCowsWithDistance(int[] stalls, int totalCows, int dist) {
        int assignedCows = 1;
        // the first cow at index-0
        int positionOfTheLastCow = 0;
        for (int i = 1; i < stalls.length; ++i) {
            // assign the stall the next cow
            if (stalls[i] - stalls[positionOfTheLastCow] >= dist) {
                ++assignedCows;
                positionOfTheLastCow = i;
            }
        }
        return assignedCows >= totalCows;
    }

    private int aggressiveCows(int[] stalls, int k) {
        // impossible to assign stalls
        if (k > stalls.length) {
            return -1;
        }
        Arrays.sort(stalls);
        // min. possible distnace b/w any two cows
        int low = 1;
        // max. possible distance b/w any two cows
        int high = stalls[stalls.length - 1] - stalls[0];
        int maxDistance = Integer.MIN_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canWePlaceCowsWithDistance(stalls, k, mid)) {
                low = mid + 1;
                maxDistance = Math.max(maxDistance, mid);
            } else {
                high = mid - 1;
            }
        }
        return maxDistance;
    }

    public static void main(String[] args) {
        int[] stalls = { 1, 2, 3 };
        int k = 2;
        System.out.println(new AggressiveCows().aggressiveCows(stalls, k));
    }
}
