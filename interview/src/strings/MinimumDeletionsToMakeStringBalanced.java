/**
 * date 30/07/24 13:41
 *
 * @author akhil.p
 *
 * https://leetcode.com/problems/minimum-deletions-to-make-string-balanced/
 *
 */
package strings;

public class MinimumDeletionsToMakeStringBalanced {

    private int minimumDeletions(String s) {
        int count = 0;
        int deletions = 0;
        for (char c : s.toCharArray()) {
            if (c == 'b') {
                ++count;
            } else if (count != 0) {
                --count;
                ++deletions;
            }
        }
        return deletions;
    }

    public static void main(String[] args) {
        String s = "aababbab";
        System.out.println(new MinimumDeletionsToMakeStringBalanced().minimumDeletions(s));
    }
}
