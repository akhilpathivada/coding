/**
 * Date 24/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/word-break/
 *
 * Time Complexity : O(N ^ 2)
 * Space Complexity : O(N)
 *
 */
package dp.lis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreakI {
        
        private boolean isWordBreak(String s, List<String> wordDict) {
                int n = s.length();
                boolean[] dp = new boolean[n + 1];
                dp[0] = true;
                for (int i = 1; i <= n; ++i) {
                        for (int j = 0; j < i; ++j) {
                                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                                        System.out.println("for i = j " + i + " - " + j);
                                        dp[i] = true;
                                        break;
                                }
                        }
                }
                return dp[n];
        }
        
        public static void main(String[] args) {
                String s = "applepenapple";
                List<String> wordDict = new ArrayList<String>(Arrays.asList( "apple", "pen"));
                System.out.println(new WordBreakI().isWordBreak(s, wordDict));
        }
}
