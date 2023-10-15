/**
 * https://leetcode.com/problems/rotate-string/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 * */
package strings;

public class RotateString {

    private boolean rotateString(String s, String goal) {
        // There lengths must be same and str2 must be
        // a substring of str1 concatenated with str1.
        return (s.length() == goal.length())
                && ((s + s).indexOf(goal) != -1);
    }

    public static void main(String[] args) {
        String s = "abcde", goal = "cdeab";
        System.out.println(new RotateString().rotateString(s, goal));
    }
}
