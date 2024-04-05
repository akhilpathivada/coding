/**
 *
 * Date 05/04/2024
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/increasing-triplet-subsequence/description/
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * */
package misc;

public class IncreasingTripletSubsequence {

    private boolean increasingTriplet(int[] nums) {
        int i = Integer.MAX_VALUE;
        int j = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= i) { // 'i' found
                i = num;
            } else if (num <= j) { // 'j' found where i < j
                j = num;
            } else { // 'k' found where i < j < k
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 0, 4, 6};
        System.out.println(new IncreasingTripletSubsequence().increasingTriplet(nums));
    }
}
