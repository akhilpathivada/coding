/**
 * author: akhilpathivada
 * time: 29/09/24 08:10
 *
 * https://leetcode.com/problems/k-th-smallest-in-lexicographical-order/description/
 *
 */
package trie;

public class KthSmallestInLexicographicalOrder {

    // helper function to count the numbers within the range [current, n]
    private long getCountOfNumbersWithPrefix(long prefix, long n) {
        long current = prefix;
        long next = prefix + 1;
        long count = 0;
        while (current <= n) {
            count += (int) (Math.min(n + 1, next) - current);
            current *= 10;
            next *= 10;
        }
        return count;
    }

    private int findKthNumber(int n, int k) {
        long current = 1;
        --k;
        while (k > 0) {
            long count = getCountOfNumbersWithPrefix(current, n);
            if (count <= k) {
                ++current;
                k -= (int) count;
            } else {
                current *= 10;
                --k;
            }
        }
        return (int) current;
    }

    public static void main(String[] args) {
        int n = 100, k = 10;
        System.out.println(new KthSmallestInLexicographicalOrder().findKthNumber(n, k));
    }
}
