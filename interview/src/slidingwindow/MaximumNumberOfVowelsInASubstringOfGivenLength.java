/**
 * date 02/08/24 15:45
 *
 * @author akhil.p
 *
 * https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/
 *
 */
package slidingwindow;

public class MaximumNumberOfVowelsInASubstringOfGivenLength {

    private boolean isvowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    private int maxVowels(String s, int k) {
        int left = 0;
        int count = 0;
        int result = 0;
        for (int right = 0; right < s.length(); ++right) {
            count += isvowel(s.charAt(right)) ? 1 : 0;
            if (right - left + 1 > k) {
                count -= isvowel(s.charAt(left++)) ? 1 : 0;
            }
            result = Math.max(result, count);
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "abciiidef";
        int k = 3;
        System.out.println(new MaximumNumberOfVowelsInASubstringOfGivenLength().maxVowels(s, k));
    }
}
