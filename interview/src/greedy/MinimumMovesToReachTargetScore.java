/**
 * date 18/07/24 15:23
 *
 * @author akhil.p
 *
 * https://leetcode.com/problems/minimum-moves-to-reach-target-score/description/
 */
package greedy;

public class MinimumMovesToReachTargetScore {

    private int minMoves(int target, int maxDoubles) {
        int moves = 0;
        while (target > 1) {
            if (maxDoubles > 0 && target % 2 == 0) {
                target /= 2;
                --maxDoubles;
                ++moves;
            } else if (maxDoubles > 0 && target % 2 == 1) {
                --target;
                ++moves;
            } else {
                moves += (target - 1);
                target = 1;
            }
        }
        return moves;
    }

    public static void main(String[] args) {
        int target = 19, maxDoubles = 2;
        System.out.println(new MinimumMovesToReachTargetScore().minMoves(target, maxDoubles));
    }
}
