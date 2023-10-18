/**
 * https://leetcode.com/problems/maximum-candies-allocated-to-k-children/description/
 *
 * Time Complexity: O(log(biggestCandyAvailable) * N)
 * Space Complexity: O(1)
 * */
package binarysearch;

import java.util.Arrays;

public class MaximumCandiesAllocatedToKChildren {

    private boolean pileCanDistributeEqually(int[] candies, int pileToDistribute, long k) {
        // no pile available to distribute
        if (pileToDistribute == 0) {
            return true;
        }
        long personsGotCandy = 0;
        for (int candy : candies) {
            // distribute to persons
            personsGotCandy += candy / pileToDistribute;
            // all persons got candies
            if (personsGotCandy >= k) {
                return true;
            }
        }
        return false;
    }

    private int maximumCandies(int[] candies, long k) {
        int biggestCandyAvailable = Arrays.stream(candies).max().getAsInt();
        if (k > biggestCandyAvailable) {
            return 0;
        }
        int result = 0;
        // minimum candy a person can get is 0
        // maximum candy a person can get is biggest candy available
        int start = 0, end = biggestCandyAvailable;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (pileCanDistributeEqually(candies, mid, k)) {
                start = mid + 1;
                result = Math.max(result, mid);
            } else {
                end = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] candies = { 5, 8, 6 };
        int k = 3;
        System.out.println(new MaximumCandiesAllocatedToKChildren().maximumCandies(candies, k));
    }
}
