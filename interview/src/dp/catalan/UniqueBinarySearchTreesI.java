/**
 * https://leetcode.com/problems/unique-binary-search-trees/description/
 *
 * Time Complexity: O(N ^ 2)
 * Space Complexity: O(N)
 */
package dp.catalan;

public class UniqueBinarySearchTreesI {

    private int numTrees(int n) {
        final int[] catalan = new int[n + 1];
        catalan[0] = catalan[1] = 1;
        for (int i = 2; i <= n; ++i) {
            catalan[i] = 0;
            for (int j = 0; j < i; ++j) {
                catalan[i] += catalan[j] * catalan[i - j - 1];
            }
        }
        return catalan[n];
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(new UniqueBinarySearchTreesI().numTrees(n));
    }
}
