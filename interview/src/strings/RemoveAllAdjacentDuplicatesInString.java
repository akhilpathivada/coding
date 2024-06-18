/**
 * author: akhilpathivada
 * time: 18/06/24 16:52
 *
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/description/
 *
 */
package strings;

public class RemoveAllAdjacentDuplicatesInString {

    private String removeDuplicates(String s) {
        final StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()) {
            int size = result.length();
            if (size > 0 && result.charAt(size - 1) == c) {
                result.deleteCharAt(size - 1);
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "azxxzy";
        System.out.println(new RemoveAllAdjacentDuplicatesInString().removeDuplicates(s));
    }
}
