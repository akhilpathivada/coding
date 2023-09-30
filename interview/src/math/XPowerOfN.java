/**
 * https://leetcode.com/problems/powx-n/
 *
 * Time Complexity: O(log(N))
 * Space Complexity: O(1)
 * */
package math;

public class XPowerOfN {

    private double myPow(int x, int n) {
        // if 'n' is -ve : make it +ve and inverse 'x'
        if (n < 0){
            n = -n;
            x = 1 / x;
        }

        double pow = 1;
        while (n != 0) {
            // equivalent to if((n % 2) != 0) i.e. multiply only when the number
            if ((n & 1) != 0) {
                pow *= x;
            }
            x *= x;
            // equivalent to n = n / 2; i.e. keep dividing the number by 2
            n >>>= 1;
        }
        return pow;
    }

    public static void main(String[] args) {
        int x = 7, n = 11;
        System.out.println(new XPowerOfN().myPow(x, n));
    }
}
