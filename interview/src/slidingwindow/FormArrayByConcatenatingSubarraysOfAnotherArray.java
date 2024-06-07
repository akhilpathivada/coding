/**
 * author: akhilpathivada
 * time: 07/06/24 16:23
 *
 * https://leetcode.com/problems/form-array-by-concatenating-subarrays-of-another-array/description/
 * 
 */
package slidingwindow;

public class FormArrayByConcatenatingSubarraysOfAnotherArray {

    private boolean isMatch(int[] group, int[] nums, int start) {
        for (int i = 0; i < group.length; ++i) {
            if (group[i] != nums[start + i]) {
                return false;
            }
        }
        return true;
    }

    public boolean canChoose(int[][] groups, int[] nums) {
        int i = 0;
        for (int j = 0; i < groups.length && j + groups[i].length <= nums.length; ) {
            j += isMatch(groups[i], nums, j) ? groups[i++].length : 1;
        }
        return i == groups.length;
    }

    public static void main(String[] args) {
        int[][] groups = {{10, -2}, {1, 2, 3, 4}};
        int[] nums = {1, 2, 3, 4, 10, -2};
        System.out.println(new FormArrayByConcatenatingSubarraysOfAnotherArray().canChoose(groups, nums));
    }
}
