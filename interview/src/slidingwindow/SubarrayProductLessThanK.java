/**
 * Date 13/04/24
 * Time 11:31
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/subarray-product-less-than-k/description/
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
package slidingwindow;

public class SubarrayProductLessThanK {

    private int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) {
            return 0;
        }
        int left = 0;
        int count = 0;
        int product = 1;
        for (int right = 0; right < nums.length; ++right) {
            product *= nums[right];
            while (product >= k) {
                product /= nums[left++];
            }
            count += right - left + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 6};
        int k = 100;
        System.out.println(new SubarrayProductLessThanK().numSubarrayProductLessThanK(nums, k));
    }
}
