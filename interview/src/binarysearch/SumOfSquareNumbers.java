/**
 * author: akhilpathivada
 * time: 10/06/24 19:04
 *
 * https://leetcode.com/problems/sum-of-square-numbers/description/
 *
 */
package binarysearch;

public class SumOfSquareNumbers {

    private boolean judgeSquareSum(int c) {
        long left = 0, right = (long) Math.sqrt(c);
        while (left <= right) {
            long square = left * left + right * right;
            if (square < c) {
                ++left;
            } else if (square > c) {
                --right;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int c = 5;
        System.out.println(new SumOfSquareNumbers().judgeSquareSum(c));
    }
}
