package slidingwindow;

/**
 * Date 14/04/24
 * Time 16:55
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/get-equal-substrings-within-budget/description/
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class GetEqualSubstringsWithinBudget {

    private int equalSubstring(String s, String t, int maxCost) {
        int first = 0;
        int cost = 0;
        int result = 0;
        for (int second = 0; second < s.length(); ++second) {
            cost += Math.abs(s.charAt(second) - t.charAt(second));
            while (cost > maxCost) {
                cost -= Math.abs(s.charAt(first) - t.charAt(first++));
            }
            result = Math.max(result, second - first + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "abcd", t = "bcdf";
        int maxCost = 3;
        System.out.println(new GetEqualSubstringsWithinBudget().equalSubstring(s, t, maxCost));
    }
}
