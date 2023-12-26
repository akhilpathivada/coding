/**
 * @author akhilpathivada
 * <p>
 * date : 26/12/23
 * time: 09:06
 *
 * Time Complexity: O(N + M) where N is the length of the text and M is the length of the pattern to be found.
 * Space Complexity: O(M)
 */
package patternmatch.kmp;

public class RepeatedStringMatch {

    // lps :: Longest Prefix Suffix
    // compute lps array to maintain size of suffix which is same as prefix, where
    // lps[i] -> size of suffix ending at 'i' which has a matching prefix
    private int[] computeLPS(char[] pattern, int m) {
        int[] lps = new int[m];
        int len = 0; // length of the previous longest prefix substring
        lps[0] = 0; // lps[0] is always 0
        // the loop calculates lps[i] for i = 1 to m - 1
        for (int i = 1; i < m; ) {
            // characters match : found a suffix (ending here at 'i')
            // which has same prefix with size of 'len + 1'
            if (pattern[i] == pattern[len]) {
                lps[i] = len + 1;
                ++len;
                ++i;
            } else {
                if (len != 0) { // 'len' should go back to the point where, the next highest string match
                    len = lps[len - 1];
                } else { // no matching prefix found, so mark lps[i] = 0
                    lps[i] = 0;
                    ++i;
                }
            }
        }
        return lps;
    }

    private boolean isSubstring(char[] text, char[] pattern, int[] lps) {
        int m = pattern.length;
        int n = text.length;
        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            if (text[i] == pattern[j]) {
                ++i;
                ++j;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    ++i;
                }
            }
            if (j == m) {
                return true;
            }
        }
        return false;
    }

    private int repeatedStringMatch(String a, String b) {
        int m = a.length();
        int n = b.length();
        int minTimesToRepeat = (int) Math.ceil((double) n / m);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < minTimesToRepeat; ++i) {
            result.append(a);
        }
        int[] lps = computeLPS(result.toString().toCharArray(), result.length());
        // (0) possibly itself, (1) one added before/after , (2) one before and one after for the 'result'
        // ref: https://leetcode.com/problems/repeated-string-match/solutions/3825275/kmp-algo-java-code-explained/
        for (int i = 0; i < 3; ++i) {
            // check 'b' is a substring of 'result'
            if (isSubstring(result.toString().toCharArray(), b.toCharArray(), lps)) {
                return minTimesToRepeat + i;
            }
            result.append(a);
        }
        return -1;
    }

    public static void main(String[] args) {
        String a = "abcd", b = "cdabcdab";
        System.out.println(new RepeatedStringMatch().repeatedStringMatch(a, b));
    }
}
