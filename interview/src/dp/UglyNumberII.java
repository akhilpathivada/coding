/**
 *
 * https://leetcode.com/problems/ugly-number/description/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 *
 */
package dp;

public class UglyNumberII {

    public int nthUglyNumber(int n) {
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        int next_multiple_of_2 = 2;
        int next_multiple_of_3 = 3;
        int next_multiple_of_5 = 5;
        for (int i = 1; i <= n; ++i) {
            int next_ugly_number = Math.min(next_multiple_of_2, Math.min(next_multiple_of_3, next_multiple_of_5));
            dp[i] = next_ugly_number;
            if (next_ugly_number == next_multiple_of_2) {
                ++i2;
                next_multiple_of_2 = dp[i2] * 2;
            }
            if (next_ugly_number == next_multiple_of_3) {
                ++i3;
                next_multiple_of_3 = dp[i3] * 3;
            }
            if (next_ugly_number == next_multiple_of_5) {
                ++i5;
                next_multiple_of_5 = dp[i5] * 5;
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int n = 150;
        System.out.println(new UglyNumberII().nthUglyNumber(n));
    }
}
