/**
 * Date 12/04/24
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/description/
 *
 *
 */
package binarysearch;

public class KthSmallestNumberInMultiplicationTable {

    private int countOfSmallerNumbersThanMid(int m, int n, int num) {
        int countOfSmallerNumbers = 0;
        for (int i = 1; i <= m; ++i) {
            int c = Math.min(num / i, n);
            if (c == 0) {
                break;
            }
            countOfSmallerNumbers += c;
        }
        return countOfSmallerNumbers;
    }

    private int findKthNumber(int m, int n, int k) {
        // min. smallest number
        int low = 1;
        // max. smallest number
        int high = m * n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (countOfSmallerNumbersThanMid(m, n, mid) >= k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int m = 3, n = 3, k = 5;
        System.out.println(new KthSmallestNumberInMultiplicationTable().findKthNumber(m, n, k));
    }
}
