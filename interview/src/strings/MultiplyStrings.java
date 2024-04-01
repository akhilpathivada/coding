/**
 * @author akhilpathivada
 * <p>
 * date : 01/04/24
 * time: 12:20
 *
 * https://leetcode.com/problems/multiply-strings/
 *
 * Time Complexity : O(m + n) * O(m) -> O(m * n)
 * Space Complexity: O(1)
 */
package strings;

public class MultiplyStrings {

    private String multiply(String num1, String num2) {
        // base case
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        StringBuilder product = new StringBuilder();
        int m = num1.length() - 1;
        int n = num2.length() - 1;
        int carry = 0;
        for (int i = 0; i <= m + n || carry != 0; ++i) {
            for (int j = Math.max(0, i - n); j <= Math.min(i, m); ++j) {
                carry += (num1.charAt(m - j) - '0') * (num2.charAt(n - i + j) - '0');
            }
            product.append((char) (carry % 10 + '0'));
            carry /= 10;
        }
        return product.reverse().toString();
    }

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        System.out.println(new MultiplyStrings().multiply(num1, num2));
    }
}
