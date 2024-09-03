/**
 * author: akhilpathivada
 * time: 03/09/24 15:10
 *
 * https://leetcode.com/problems/sum-of-digits-of-string-after-convert/description/
 *
 */
package strings;

public class SumOfDigitsOfStringAfterConvert {

    private int getLucky(String s, int k) {
        StringBuilder number = new StringBuilder();
        for (char c : s.toCharArray()) { // convert each character in the string to its corresponding numeric value
            number.append(c - 'a' + 1);
        }
        while (k-- > 0) {
            int sum = number.toString().chars().reduce(0, (temp, c) -> temp + (c - '0'));
            number = new StringBuilder(String.valueOf(sum));
        }
        return Integer.parseInt(number.toString());
    }

    public static void main(String[] args) {
        String s = "leetcode";
        int k = 2;
        System.out.println(new SumOfDigitsOfStringAfterConvert().getLucky(s, k));
    }
}
