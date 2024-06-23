/**
 * author: akhilpathivada
 * time: 23/06/24 20:56
 *
 * https://leetcode.com/problems/find-the-longest-semi-repetitive-substring/description/
 *
 */
package slidingwindow;

public class FindTheLongestSemiRepetitiveSubstring {

    private int longestSemiRepetitiveSubstring(String s) {
        if (s.length() == 1) {
            return 1;
        }
        int left = 0;
        int result = 0;
        int countOfAdjacentPairsSoFar = 0;
        for (int right = 1; right < s.length(); ++right) {
            countOfAdjacentPairsSoFar += s.charAt(right) == s.charAt(right - 1) ? 1 : 0;
            if (countOfAdjacentPairsSoFar > 1) {
                countOfAdjacentPairsSoFar -= s.charAt(++left) == s.charAt(left - 1) ? 1 : 0;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "52233";
        System.out.println(new FindTheLongestSemiRepetitiveSubstring().longestSemiRepetitiveSubstring(s));
    }
}
