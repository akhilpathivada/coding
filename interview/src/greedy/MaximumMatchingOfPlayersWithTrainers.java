/**
 * author: akhilpathivada
 * time: 16/05/24 22:00
 *
 * https://leetcode.com/problems/maximum-matching-of-players-with-trainers/
 *
 */
package greedy;

import java.util.Arrays;

public class MaximumMatchingOfPlayersWithTrainers {

    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int matchings = 0;
        int i = 0;
        int j = 0;
        while (i < players.length && j < trainers.length) {
            if (players[i] <= trainers[j]) {
                ++i;
                ++matchings;
            }
            ++j;
        }
        return matchings;
    }

    public static void main(String[] args) {
        int[] players = {4, 7, 9};
        int[] trainers = {8, 2, 5, 8};
        System.out.println(new MaximumMatchingOfPlayersWithTrainers().matchPlayersAndTrainers(players, trainers));
    }
}
