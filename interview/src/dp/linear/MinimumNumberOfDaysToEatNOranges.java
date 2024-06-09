/**
 * author: akhilpathivada
 * time: 09/06/24 11:37
 *
 * https://leetcode.com/problems/minimum-number-of-days-to-eat-n-oranges/description/
 *
 */
package dp.linear;

import java.util.HashMap;
import java.util.Map;

public class MinimumNumberOfDaysToEatNOranges {

    private int f(int n) {
        if (n == 0) {
            return 0;
        }
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        int c = Integer.MAX_VALUE;
        if (n % 2 != 0 || n % 3 != 0) {
            a = f(n - 1);
        }
        if (n % 2 == 0) {
            b = f(n / 2);
        }
        if (n % 3 == 0) {
            c = f(n / 3);
        }
        return 1 + Math.min(a, Math.min(b, c));
    }

    private int memoize(int n, Map<Integer, Integer> dp) {
        if (n == 0) {
            return 0;
        }
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        int c = Integer.MAX_VALUE;
        if (dp.containsKey(n)) {
            return dp.get(n);
        }
        if (n % 2 != 0 || n % 3 != 0) {
            a = memoize(n - 1, dp);
        }
        if (n % 2 == 0) {
            b = memoize(n / 2, dp);
        }
        if (n % 3 == 0) {
            c = memoize(n / 3, dp);
        }
        int result = 1 + Math.min(a, Math.min(b, c));
        dp.put(n, result);
        return result;
    }

    private int minDays(int n) {
        // recursion
        System.out.println(f(n));

        // memoization
        return memoize(n, new HashMap<>());
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(new MinimumNumberOfDaysToEatNOranges().minDays(n));
    }
}
