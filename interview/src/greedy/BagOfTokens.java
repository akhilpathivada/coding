/**
 * author: akhilpathivada
 * time: 25/05/24 07:09
 *
 * https://leetcode.com/problems/bag-of-tokens/description/
 *
 */
package greedy;

import java.util.Arrays;

public class BagOfTokens {

    private int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int start = 0;
        int end = tokens.length - 1;
        int score = 0;
        while (start <= end) {
            if (power >= tokens[start]) {
                ++score;
                power -= tokens[start++];
            } else if (score > 0 && start != end) { // just hold the score when start and end are same, instead of losing
                --score;
                power += tokens[end--];
            } else {
                break;
            }
        }
        return score;
    }

    public static void main(String[] args) {
        int[] tokens = {100, 200, 300, 400};
        int power = 200;
        System.out.println(new BagOfTokens().bagOfTokensScore(tokens, power));
    }
}
