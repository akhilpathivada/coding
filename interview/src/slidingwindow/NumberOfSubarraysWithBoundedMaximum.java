/**
 * date 08/08/24 16:00
 *
 * @author akhil.p

 * https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/description/
 *
 */
package slidingwindow;

public class NumberOfSubarraysWithBoundedMaximum {

    // https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/solutions/1278743/c-java-python-easy-to-understand-solution-clean-concise-o-n/
    private int countOfSubarraysLessThanBound(int[] nums, int bound) {
        int count = 0;
        int result = 0;
        for (int num : nums) {
            count = num <= bound ? count + 1 : 0;
            result += count;
        }
        return result;
    }

    private int numSubarrayBoundedMax(int[] nums, int left, int right) {
        return countOfSubarraysLessThanBound(nums, right) - countOfSubarraysLessThanBound(nums, left - 1);
    }

    public static void main(String[] args) {
        int[] nums = {2, 9, 2, 5, 6};
        int left = 2;
        int right = 8;
        System.out.println(new NumberOfSubarraysWithBoundedMaximum().numSubarrayBoundedMax(nums, left, right));
    }
}
