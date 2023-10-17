/**
 * https://leetcode.com/problems/optimal-partition-of-string/description/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * */
package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class OptimalPartitionOfString {

    private int partitionString(String s) {
        // base case
        if (s == null || s.isEmpty()) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int substrings = 1;
        for (int i = 0; i < s.length(); ++i) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            // if substing size == map.size then there is no repetion of character
            // othersize there is repetion of character
            if (i - start + 1 == map.size()) {
                continue;
            }
            ++substrings;
            map.clear();
            map.put(s.charAt(i), 1);
            start = i;
        }
        return substrings;
    }

    public static void main(String[] args) {
        String s = "abacaba";
        System.out.println(new OptimalPartitionOfString().partitionString(s));
    }
}
