/**
 *
 * https://leetcode.com/problems/group-anagrams/description/
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 * Example :
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 * */
package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

        private List<List<String>> groupAnagrams(String[] strs) {
                if (strs == null || strs.length == 0) {
                        return new ArrayList<>();
                }
                final Map<String, List<String>> map = new HashMap<>();
                for (String s : strs) {
                        char[] ca = new char[26];
                        for (char ch : s.toCharArray()) {
                                ca[ch - 'a']++;
                        }
                        map.computeIfAbsent(String.valueOf(ca), list -> new ArrayList<>()).add(s);
                }
                return new ArrayList<>(map.values());
        }

        public static void main(String[] args) {
                String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
                System.out.println("Grouped Anagrams : " + new GroupAnagrams().groupAnagrams(strs));
        }
}
