/**
 * author: akhilpathivada
 * time: 10/06/24 12:53
 *
 * https://leetcode.com/problems/integer-replacement/description/
 */
package dp.linear;

import java.util.HashMap;
import java.util.Map;

public class IntegerReplacement {

    private int f(int n) {
        if (n == 1) {
            return 0;
        }
        return 1 + (n % 2 == 0 ? f(n / 2) : Math.min(f(n + 1), f(n - 1)));
    }

    private int memoize(int n, Map<Integer, Integer> dp) {
        if (n == 1) {
            return 0;
        }
        if (dp.containsKey(n)) {
            return dp.get(n);
        }
        int result = 1 + (n % 2 == 0 ? memoize(n / 2, dp) : Math.min(memoize(n + 1, dp), memoize(n - 1, dp)));
        dp.put(n, result);
        return result;
    }

    private int integerReplacement(int n) {
        // recursion
        System.out.println(f(n));

        // memoization
        final Map<Integer, Integer> dp = new HashMap<>();
        dp.put(Integer.MAX_VALUE, 32);
        return memoize(n, dp);
    }

    public static void main(String[] args) {
        int n = 8;
        System.out.println(new IntegerReplacement().integerReplacement(n));
    }
}
