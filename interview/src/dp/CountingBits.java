/**
 * https://leetcode.com/problems/counting-bits/description/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 * */
package dp;

import java.util.Arrays;

public class CountingBits {

    private int[] countBits(int n) {
        if (n == 0) {
            return new int[1];
        }
        int[] result = new int[n + 1];
        result[0] = 0;
        result[1] = 1;
        for (int i = 2; i <= n; ++i) {
            result[i] = (i % 2 == 0) ? result[i / 2] : result[i / 2] + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(Arrays.toString(new CountingBits().countBits(n)));
    }
}
