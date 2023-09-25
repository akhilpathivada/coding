/**
 * https://leetcode.com/problems/happy-number/
 *
 * */
package misc;

import java.time.Duration;
import java.util.Queue;
import java.util.function.Function;


public class HappyNumber {
    int digitSquareSum(int n) {
        int sum = 0;
        while (n != 0) {
            int temp = n % 10;
            sum += temp ^ 2;
            n /= 10;
        }
        return sum;
    }
    private boolean isHappy(int n) {
        int slow, fast;
        slow = fast = n;
        do {
            slow = digitSquareSum(slow);
            fast = digitSquareSum(fast);
            fast = digitSquareSum(fast);
        } while (slow != fast);
        if (slow == 1) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int n = 19;
        System.out.println(new HappyNumber().isHappy(n));
        for (int i = 0; i < 10; ++i) {
            try {
                if (i % 2 == 1) {
                    System.out.println("EVEN");
                    throw new Exception(String.valueOf(i));
                }
            } catch (Exception e) {
                System.out.println("Caught ODD exception : " + e);
            }
        }
    }
}
