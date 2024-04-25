/**
 * Date 08/04/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/edit-distance-dp-5/
 *
 * https://leetcode.com/problems/edit-distance/description/
 *
 * Time Complexity : O(m * n)
 */
package dp.lcs;

public class EditDistance {

    private int min(int a, int b, int c) {
        return (a < b) ? (Math.min(a, c)) : (Math.min(b, c));
    }

    private int f(char[] X, char[] Y, int m, int n) {
        // If first string is empty, the only option is to
        // insert all characters of second string into first
        if (m == 0) {
            return n;
        }
        // If second string is empty, the only option is to
        // remove all characters of first string
        if (n == 0) {
            return m;
        }
        // If last characters of two strings are same, nothing much to do.
        // Ignore last characters and get count for remaining strings.
        if (X[m - 1] == Y[n - 1]) {
            return f(X, Y, m - 1, n - 1);
        }
        // If last characters are not same, consider all three operations on last character of first string,
        // recursively compute minimum cost for all three operations and take minimum of three values. */
        return 1 + min(
                f(X, Y, m, n - 1), // insert
                f(X, Y, m - 1, n), // remove
                f(X, Y, m - 1, n - 1) // replace
        );
    }

    private int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        char[] X = word1.toCharArray();
        char[] Y = word2.toCharArray();
        // recursion
        System.out.println(f(X, Y, m, n));
        // tabulation: create a table to store results of sub-problems
        int[][] table = new int[m + 1][n + 1];
        for (int i = 0; i <= m; ++i) {
            for (int j = 0; j <= n; ++j) {
                // If first string is empty, only option is
                // to insert all characters of second string
                if (i == 0) {
                    table[i][j] = j;
                }
                // If second string is empty, only option is
                // to remove all characters of second string
                else if (j == 0) {
                    table[i][j] = i;
                }
                // If last characters are same, ignore last
                // char and recur for remaining string
                else if (X[i - 1] == Y[j - 1]) {
                    table[i][j] = table[i - 1][j - 1];
                }
                // If the last character is different,
                // consider all possibilities and find the minimum
                else {
                    table[i][j] = 1 + min(
                            table[i][j - 1], // Insert
                            table[i - 1][j], // Remove
                            table[i - 1][j - 1]); // Replace
                }
            }
        }
        return table[m][n];
    }

    public static void main(String[] args) {
        String X = "sunday";
        String Y = "saturday";
        System.out.printf("Min. Operations required = %d", new EditDistance().minDistance(X, Y));
    }
}
