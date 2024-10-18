/**
 * author: akhilpathivada
 * time: 18/10/24 18:47
 *
 * https://leetcode.com/problems/lexicographically-smallest-string-after-substring-operation/description/
 *
 */
package strings.lexicographicalorder;

import java.util.Optional;

public class LexicographicallySmallestStringAfterSubstringOperation {

    private boolean isStringContainsOnlyA(String s) {
        return Optional.ofNullable(s)
                .map(str -> str.chars().allMatch(ch -> ch == 'a'))
                .orElse(false);
    }

    private String smallestString(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        if (isStringContainsOnlyA(s)) { // If the string contains only 'a', change the last character to 'z'
            chars[n - 1] = 'z';
            return new String(chars);
        }
        int i = 0;
        while (i < n && chars[i] == 'a') { // Find the first non-'a' character
            ++i;
        }
        while (i < n && chars[i] != 'a') { // Decrement characters until encountering 'a'
            chars[i] = (char) (chars[i] - 1);
            ++i;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String s = "acbbc";
        System.out.println(new LexicographicallySmallestStringAfterSubstringOperation().smallestString(s));
    }
}
