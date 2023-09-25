/**
 * https://leetcode.com/problems/valid-anagram/description/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 * */
package strings;

public class ValidAnagram {

    private boolean isAnagram(String s, String t) {
        int[] alphabet = new int[26];
        // hash the chars of 's'
        for (char ch : s.toCharArray()) {
            alphabet[ch - 'a']++;
        }
        // remove the hash of the chars of 't'
        for (char ch : t.toCharArray()) {
            alphabet[ch - 'a']--;
        }
        // check if the hash contains any element
        for (int i : alphabet) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(new ValidAnagram().isAnagram(s, t));
    }
}
