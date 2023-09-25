/**
 * https://leetcode.com/problems/string-to-integer-atoi/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 * */
package strings;

public class StringToInteger {

    private int myAtoi(String s) {

        int i = 0;
        int n = s.length();
        // skipping space characters at the beginning
        while (i < n && s.charAt(i) == ' ') {
            ++i;
        }
        int positiveSigns = 0;
        int negativeSigns = 0;
        // number of positive signs at the start in string
        if (i < n && s.charAt(i) == '+') {
            ++i;
            ++positiveSigns;
        }
        // number of negative signs at the start in string
        if (i < n && s.charAt(i) == '-') {
            ++i;
            ++negativeSigns;
        }
        // if both +ve and -ve sign exist, Example: +-12
        if (positiveSigns > 0 && negativeSigns > 0) {
            return 0;
        }
        double result = 0;

        while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            // (s.charAt(i) - '0') is converting character to integer
            result = result * 10 + (s.charAt(i) - '0');
            ++i;
        }
        // if negative sign exists
        if (negativeSigns > 0) {
            result = -result;
        }

        int INT_MAX = (int) Math.pow(2, 31);
        int INT_MIN = (int) Math.pow(-2, 31);

        if (result > INT_MAX) { // if ans > 2^31
            result = INT_MAX;
        }
        if (result < INT_MIN) { // if ans < -2^31
            result = INT_MIN;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        String s = "   123";
        System.out.println(new StringToInteger().myAtoi(s));
    }
}
