package dp.fibonacci;

/**
 * Date 19/04/24
 * Time 14:15
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/reach-a-number/description/
 *
 */
public class ReachANumber {

    private int f(final int target, int move, int currentPos) {
        if (Math.abs(currentPos) > Math.abs(target)) {
            return Integer.MAX_VALUE;
        }
        if (currentPos == target) {
            return move - 1;
        }
        return Math.min(f(target, move + 1, currentPos + move),
                f(target, move + 1, currentPos - move));
    }

    private int reachNumber(int target) {
        return f(target, 1, 0);
    }

    public static void main(String[] args) {
        int target = 3;
        System.out.println(new ReachANumber().reachNumber(target));
    }
}
