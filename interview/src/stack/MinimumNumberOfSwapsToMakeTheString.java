/**
 * Date 06/04/24
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/description/
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
package stack;

public class MinimumNumberOfSwapsToMakeTheString {

    private int minSwaps(String s) {
        int maxClose = 0;
        int extraClose = 0;
        for (char c : s.toCharArray()) {
            if (c == ']') {
                ++extraClose;
            } else {
                --extraClose;
            }
            maxClose = Math.max(maxClose, extraClose);
        }
        return (maxClose + 1) / 2;
    }

    public static void main(String[] args) {
        String s = "]]][[[";
        System.out.println(new MinimumNumberOfSwapsToMakeTheString().minSwaps(s));
    }
}
