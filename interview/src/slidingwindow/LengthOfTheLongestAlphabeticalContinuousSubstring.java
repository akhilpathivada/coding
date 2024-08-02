/**
 * date 02/08/24 15:59
 *
 * @author akhil.p
 *
 * https://leetcode.com/problems/length-of-the-longest-alphabetical-continuous-substring/description/
 *
 */
package slidingwindow;

public class LengthOfTheLongestAlphabeticalContinuousSubstring {

    private int longestContinuousSubstring(String s) {
        int left = 0;
        int result = 1;
        for (int right = 1; right < s.length(); ++right) {
            if (s.charAt(right) != (char) (s.charAt(left) + right - left)) {
                left = right;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }

    public static void main(String[] args) {
         String s = "abacaba";
//        String s = "abcde";
        System.out.println(new LengthOfTheLongestAlphabeticalContinuousSubstring().longestContinuousSubstring(s));
    }
}
