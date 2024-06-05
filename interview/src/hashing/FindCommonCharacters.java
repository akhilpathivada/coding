/**
 * author: akhilpathivada
 * time: 05/06/24 11:35
 *
 * https://leetcode.com/problems/find-common-characters/description/
 *
 */
package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindCommonCharacters {

    private List<String> commonChars(String[] words) {
        final int[] dict = new int[26];
        final List<String> result = new ArrayList<>();
        for (char c : words[0].toCharArray()) {
            dict[c - 'a']++;
        }
        for (int i = 1; i < words.length; ++i) {
            int[] count = new int[26];
            for (char c : words[i].toCharArray()) {
                count[c - 'a']++;
            }
            // update the dict
            for (int j = 0; j < 26; ++j) {
                dict[j] = Math.min(dict[j], count[j]);
            }
        }
        for (int i = 0; i < 26; ++i) {
            while (dict[i]-- > 0) {
                result.add(Character.toString((char) i + 'a'));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] words = {"bella", "label", "roller"};
        System.out.println(new FindCommonCharacters().commonChars(words));
    }
}
