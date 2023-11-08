/**
 * https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/description/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * */
package hashing;

import java.util.HashMap;
import java.util.Map;

public class PairsOfSongsWithTotalDurationsDivisibleBy60 {

    private int numPairsDivisibleBy60(int[] time) {
        int countOfPairs = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int t : time) {
            int partner = (600 - t) % 60;
            if (map.containsKey(partner)) {
                countOfPairs += map.get(partner);
            }
            map.put(t % 60, map.getOrDefault(t % 60, 0) + 1);
        }
        return countOfPairs;
    }

    public static void main(String[] args) {
        int[] time = { 30, 20, 150, 100, 40 };
        System.out.println(new PairsOfSongsWithTotalDurationsDivisibleBy60().numPairsDivisibleBy60(time));
    }
}
