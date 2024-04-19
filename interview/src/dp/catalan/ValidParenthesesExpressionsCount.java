/**
 * https://www.geeksforgeeks.org/find-number-valid-parentheses-expressions-given-length/
 *
 * Time Complexity: O(N ^ 2)
 * Space Complexity: O(N)
 * */
package dp.catalan;

public class ValidParenthesesExpressionsCount {

    private int catalan(int n) {
        int[] catalan = new int[n + 1];
        catalan[0] = catalan[1] = 1;
        for (int i = 2; i <= n; ++i) {
            catalan[i] = 0;
            for (int j = 0; j < i; ++j) {
                catalan[i] += catalan[j] * catalan[i - j - 1];
            }
        }
        return catalan[n];
    }

    private int findWays(int n) {
        // If n is odd, not possible to
        // create any valid parentheses
        if ((n & 1) != 0) {
            return 0;
        }
        // otherwise return n/2'th Catalan Number
        return catalan(n / 2);
    }

    public static void main(String[] args) {
        int n = 6;
        System.out.println(new ValidParenthesesExpressionsCount().findWays(n));
    }
}
