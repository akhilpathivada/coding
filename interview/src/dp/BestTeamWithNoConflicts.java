/**
 *
 * https://leetcode.com/problems/best-team-with-no-conflicts/description/
 *
 * Time Complexity : O(N ^ 2)
 * Space Complexity : O(N)
 */
package dp;

import java.util.Arrays;

public class BestTeamWithNoConflicts {

    private int bestTeamScore(int[] scores, int[] ages) {
        int n = ages.length;
        int[][] ageScorePair = new int[n][2];
        int[] dp = new int[n];
        for (int i = 0; i < n; ++i) {
            ageScorePair[i][0] = ages[i];
            ageScorePair[i][1] = scores[i]; // team is [age, score]
        }
        // double sort first by age then by score, then we can traverse from young to old
        Arrays.sort(ageScorePair, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        dp[0] = ageScorePair[0][1];
        for (int i = 1; i < n; ++i) {
            int max = ageScorePair[i][1];
            for (int j = 0; j < i; ++j) {
                if (ageScorePair[i][1] >= ageScorePair[j][1]) {
                    max = Math.max(max, dp[j] + ageScorePair[i][1]);
                }
            }
            dp[i] = max;
        }
        int maxScore = dp[0];
        for (int d : dp) {
            maxScore = Math.max(maxScore, d);
        }
        return maxScore;
    }

    public static void main(String[] args) {
        int[] scores = { 1, 3, 5, 10, 15 }, ages = { 1, 2, 3, 4, 5 };
        System.out.println(new BestTeamWithNoConflicts().bestTeamScore(scores, ages));
        int[] scores2 = { 4, 5, 6, 5 }, ages2 = { 2, 1, 2, 1 };
        System.out.println(new BestTeamWithNoConflicts().bestTeamScore(scores2, ages2));
        int[] scores3 = { 1, 2, 3, 5 }, ages3 = { 8, 9, 10, 1 };
        System.out.println(new BestTeamWithNoConflicts().bestTeamScore(scores3, ages3));
    }
}
