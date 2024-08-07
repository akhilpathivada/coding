/**
 * date 07/08/24 15:24
 *
 * @author akhil.p
 *
 * https://leetcode.com/problems/adding-spaces-to-a-string/description/
 *
 */
package strings;

public class AddingSpacesToAString {

    private String addSpaces(String s, int[] spaces) {
        final StringBuilder result = new StringBuilder();
        for (int i = 0, j = 0; j < s.length(); ++j) {
            if (i < spaces.length && j == spaces[i]) {
                result.append(' ');
                ++i;
            }
            result.append(s.charAt(j));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "LeetcodeHelpsMeLearn";
        int[] spaces = {8, 13, 15};
        System.out.println(new AddingSpacesToAString().addSpaces(s, spaces));
    }
}
