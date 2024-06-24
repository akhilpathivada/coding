/**
 * author: akhilpathivada
 * time: 24/06/24 09:05
 *
 * https://leetcode.com/problems/find-the-pivot-integer/
 *
 */
package prefixsum;

public class FindThePivotInteger {

    private int pivotInteger(int n) {
        final int totalSum = n * (n + 1) / 2;
        for (int i = 1, prefixSum = 0; i <= n; ++i) {
            prefixSum += i;
            if (totalSum - prefixSum + i == prefixSum) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 8;
        System.out.println(new FindThePivotInteger().pivotInteger(n));
    }
}
