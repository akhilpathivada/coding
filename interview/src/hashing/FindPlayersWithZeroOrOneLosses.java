/**
 * author: akhilpathivada
 * time: 12/06/24 12:05
 *
 * https://leetcode.com/problems/find-players-with-zero-or-one-losses/description/
 *
 */
package hashing;

import java.util.*;

public class FindPlayersWithZeroOrOneLosses {

    public List<List<Integer>> findWinners(int[][] matches) {
        final int[] losses = new int[100001];
        final List<Integer> zeroLoss = new ArrayList<>();
        final List<Integer> oneLoss = new ArrayList<>();
        for (int[] match : matches) {
            int winner = match[0];
            int loser = match[1];
            if (losses[winner] == 0) {
                losses[winner] = -1;
            }
            if (losses[loser] == -1) {
                losses[loser] = 1;
            } else {
                losses[loser]++;
            }
        }
        for (int i = 1; i < 100001; ++i) {
            if (losses[i] == -1) {
                zeroLoss.add(i);
            } else if (losses[i] == 1) {
                oneLoss.add(i);
            }
        }
        return new ArrayList<>(Arrays.asList(zeroLoss, oneLoss));
    }

    public static void main(String[] args) {
        int[][] matches = {{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9}, {10, 4}, {10, 9}};
        System.out.println(new FindPlayersWithZeroOrOneLosses().findWinners(matches));
    }
}
