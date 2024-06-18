/**
 * author: akhilpathivada
 * time: 18/06/24 16:46
 *
 * https://leetcode.com/problems/removing-stars-from-a-string/description/
 *
 */
package strings;

public class RemovingStarsFromAString {

    private String removeStars(String s) {
        final StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '*') {
                result.deleteCharAt(result.length() - 1);
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "leet**cod*e";
        System.out.println(new RemovingStarsFromAString().removeStars(s));
    }
}
