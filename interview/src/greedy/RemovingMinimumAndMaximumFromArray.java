/**
 * author: akhilpathivada
 * time: 11/06/24 11:07
 *
 * https://leetcode.com/problems/removing-minimum-and-maximum-from-array/description/
 *
 */
package greedy;

public class RemovingMinimumAndMaximumFromArray {

    private int minimumDeletions(int[] nums) {
        int n = nums.length;
        int minIndex = 0;
        int maxIndex = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] < nums[minIndex]) {
                minIndex = i;
            }
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        // no. of operations required for the 3 possible cases
        int deletingBothFromLeft = Math.max(minIndex, maxIndex) + 1; // min, max both are on left
        int deletingBothFromRight = n - Math.min(minIndex, maxIndex);  // min, max both are on right
        int deletingFromLeftAndRight = (1 + Math.min(minIndex, maxIndex))
                + (n - Math.max(minIndex, maxIndex)); // one from left and other from right
        return Math.min(deletingFromLeftAndRight, Math.min(deletingBothFromLeft, deletingBothFromRight));
    }

    public static void main(String[] args) {
        int[] nums = {2, 10, 7, 5, 4, 1, 8, 6};
        System.out.println(new RemovingMinimumAndMaximumFromArray().minimumDeletions(nums));
    }
}
