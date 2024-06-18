/**
 * author: akhilpathivada
 * time: 18/06/24 17:03
 */
package strings;

public class RemoveAllOccurrencesOfASubstring {

    private String removeOccurrences(String s, String part) {
        final StringBuilder result = new StringBuilder();
        final int n = part.length();
        for (char c : s.toCharArray()) {
            result.append(c);
            int m = result.length();
            if (result.toString().endsWith(part)) {
                result.delete(m - n, m);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "daabcbaabcbc", part = "abc";
        // String s = "axxxxyyyyb", part = "xy";
        System.out.println(new RemoveAllOccurrencesOfASubstring().removeOccurrences(s, part));
    }
}
