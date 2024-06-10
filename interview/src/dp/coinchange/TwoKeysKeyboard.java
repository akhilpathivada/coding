/**
 * author: akhilpathivada
 * time: 10/06/24 12:39
 *
 * https://leetcode.com/problems/2-keys-keyboard/description/
 *
 */
package dp.coinchange;

public class TwoKeysKeyboard {

    private int f(int n, int step, int length, int copy, int paste) {
        if (length == n) {
            return step;
        }
        return 1 + Math.min(f(n, step + 1, length, length + copy, paste), f(n, step + 1, length + paste, copy, 0));
    }

    private int minSteps(int n) {
        return f(n, 0, 1, 1, 1);
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(new TwoKeysKeyboard().minSteps(n));
    }
}
