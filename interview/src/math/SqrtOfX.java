package math;

public class SqrtOfX {

    private static int sqrt(int x) {

        // base case
        if (x == 0 || x == 1) {
            return x;
        }
        long low = 1, high = x / 2, result = 0;
        // do Binary Search for floor(sqrt(x))
        while (low <= high) {
            long mid = (low + high) / 2;
            // if x is a perfect square
            if (mid * mid == x) {
                return (int) mid;
            }
            // Since we need floor, we update answer when
            // mid*mid is smaller than x, and move closer to sqrt(x)
            if (mid * mid < x) {
                low = mid + 1;
                result = mid;
            } else {
                high = mid - 1;
            }
        }
        return (int) result;
    }

    public static void main(String[] args) {
        int x = 125;
        System.out.println(sqrt(x));
    }
}
