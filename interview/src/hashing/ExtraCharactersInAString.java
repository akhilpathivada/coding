/**
 * author: akhilpathivada
 * time: 12/06/24 17:39
 *
 * https://leetcode.com/problems/extra-characters-in-a-string/description/
 *
 */
package hashing;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExtraCharactersInAString {

    private int minExtraChar(String s, String[] dictionary) {
        final Set<String> set = new HashSet<>(List.of(dictionary));
        int extraChars = s.length();
        for (int i = 0; i < s.length(); ++i) {
            if (set.contains(s.substring(i))) {
                ++extraChars;
            }
        }
        return extraChars;
    }

    public static void main(String[] args) {
        String s = "leetscode";
        String[] dictionary = {"leet","code","leetcode"};
        System.out.println(new ExtraCharactersInAString().minExtraChar(s, dictionary));
    }
}
