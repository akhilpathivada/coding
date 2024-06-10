/**
 * author: akhilpathivada
 * time: 10/06/24 13:45
 */
package dp.fibonacci;

public class NthTribonacciNumber {

    private int tribonacci(int n) {
        if (n <= 1) {
            return n;
        }
        int a = 0, b = 1, c = 1, d;
        while (n-- > 0) {
            d = a + b + c;
            a = b;
            b = c;
            c = d;
        }
        return c;
    }

    public static void main(String[] args) {
        int n = 25;
        System.out.println(new NthTribonacciNumber().tribonacci(n));
    }
}
