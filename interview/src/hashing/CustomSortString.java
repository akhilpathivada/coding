/**
 * author: akhilpathivada
 * time: 12/06/24 11:13
 *
 * https://leetcode.com/problems/custom-sort-string/description/
 *
 */
package hashing;

public class CustomSortString {

    private String customSortString(String order, String s) {
        final int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        final StringBuilder sb = new StringBuilder();
        for (char c : order.toCharArray()) {
            while (count[c - 'a']-- > 0) {
                sb.append(c);
            }
        }
        for (char c = 'a'; c <= 'z'; ++c) {
            while (count[c - 'a']-- > 0) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String order = "bcafg", s = "abcd";
        System.out.println(new CustomSortString().customSortString(order, s));
    }
}
