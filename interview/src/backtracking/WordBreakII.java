/**
 *
 * https://leetcode.com/problems/word-break-ii/
 *
 * Time Complexity : O(2 ^ N)
 * Space Complexity : O(N)
 *
 */
package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakII {

    private void backtrack(String s, int start, Set<String> dict, List<String> current, List<String> result) {
        // base case
        if (start == s.length()) {
            if (!current.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < current.size(); ++j) {
                    if (j == current.size() - 1) {
                        sb.append(current.get(j));
                        break;
                    }
                    sb.append(current.get(j)).append(" ");
                }
                result.add(sb.toString());
            }
            return;
        }
        for (int i = start + 1; i <= s.length(); ++i) {
            if (dict.contains(s.substring(start, i))) {
                current.add(s.substring(start, i));
                backtrack(s, i, dict, current, result);
                current.remove(current.size() - 1);
            }
        }
    }

    private List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        List<String> result = new ArrayList<>();
        backtrack(s, 0, set, new ArrayList<>(), result);
        return result;
    }

    public static void main(String[] args) {
        String s = "pineapplepenapple";
        List<String> wordDict = new ArrayList<String>(Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"));
        System.out.println(new WordBreakII().wordBreak(s, wordDict));
    }
}
