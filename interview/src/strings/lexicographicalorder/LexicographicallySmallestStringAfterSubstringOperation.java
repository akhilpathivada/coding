/**
 * author: akhilpathivada
 * time: 18/10/24 18:47
 *
 * https://leetcode.com/problems/lexicographically-smallest-string-after-substring-operation/description/
 *
 */
package strings.lexicographicalorder;

public class LexicographicallySmallestStringAfterSubstringOperation {

    // Decrements non-'a' characters starting from the given index
    private String decrementCharacters(final int start, final int n, final char[] chars) {
        for (int i = start; i < n && chars[i] != 'a'; ++i) {
            chars[i] = (char) (chars[i] - 1);
        }
        return new String(chars);
    }

    // Find the index of first non-'a' character
    private int findIndexOfFirstNonA(final int n, final char[] chars) {
        int indexOfFirstNonA = 0;
        while (indexOfFirstNonA < n && chars[indexOfFirstNonA] == 'a') { // Find the first non-'a' character
            ++indexOfFirstNonA;
        }
        return indexOfFirstNonA;
    }

    // Checks if the string contains only 'a's
    private boolean containsOnlyA(final String s) {
        return s.chars().allMatch(ch -> ch == 'a');
    }

    public String smallestString(String s) {
        char[] chars = s.toCharArray();
        int n = s.length();
        if (containsOnlyA(s)) {
            chars[n - 1] = 'z';  // If only 'a's, change the last character to 'z'
            return new String(chars);
        }
        int indexOfFirstNonA = findIndexOfFirstNonA(n, chars);
        return decrementCharacters(indexOfFirstNonA, n, chars); // Decrement characters after the first non-'a' character
    }

    public static void main(String[] args) {
        String s = "acbbc";
        System.out.println(new LexicographicallySmallestStringAfterSubstringOperation().smallestString(s));
    }
}
