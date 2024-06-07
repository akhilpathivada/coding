/**
 * author: akhilpathivada
 * time: 07/06/24 11:23
 * 
 * https://leetcode.com/problems/camelcase-matching/description/
 * 
 */
package strings;

import trie.base.TrieNode;

import java.util.ArrayList;
import java.util.List;

public class CamelcaseMatching {


    private boolean isMatch(String text, String pattern) {
        int index = 0;
        for (char c : text.toCharArray()) {
            if (index < pattern.length() && c == pattern.charAt(index)) {
                ++index;
            } else if (Character.isUpperCase(c)) {
                return false;
            }
        }
        return index == pattern.length();
    }

    private List<Boolean> camelMatch(String[] queries, String pattern) {
        final List<Boolean> result = new ArrayList<>();
        for (String query : queries) {
            result.add(isMatch(query, pattern));
        }
        return result;
    }

    public static void main(String[] args) {
        String[] queries = {"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"};
        String pattern = "FoBa";
        System.out.println(new CamelcaseMatching().camelMatch(queries, pattern));
    }
}
