/**
 * author: akhilpathivada
 * time: 18/10/24 18:47
 *
 * https://leetcode.com/problems/lexicographically-smallest-string-after-substring-operation/description/
 *
 */
package strings.lexicographicalorder;

public class LexicographicallySmallestStringAfterSubstringOperation {

    private boolean containsOnlyA(final String s) {
        return s.chars().allMatch(ch -> ch == 'a');
    }

    private String decrementCharacters(final char[] chars, final int start) {
        int n = chars.length;
        for (int i = start; i < n && chars[i] != 'a'; ++i) {
            chars[i] = (char) (chars[i] - 1);
        }
        return new String(chars);
    }

    private String smallestString(String s) {
        char[] chars = s.toCharArray();
        int n = s.length();
        if (containsOnlyA(s)) {
            chars[n - 1] = 'z'; // If the string contains only 'a', change the last character to 'z'
        } else {
            int firstNonA = 0;
            while (firstNonA < n && chars[firstNonA] == 'a') {
                ++firstNonA;
            }
            return decrementCharacters(chars, firstNonA);
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String s = "acbbc";
        System.out.println(new LexicographicallySmallestStringAfterSubstringOperation().smallestString(s));
    }
}
