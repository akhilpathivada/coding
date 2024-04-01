/**
 * @author akhilpathivada
 * <p>
 * date : 31/03/24
 * time: 09:30
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
package twopointer;

public class RemoveDuplicatesFromSortedArrayII {

    private int removeDuplicates(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        while (right < n) {
            int countOfDuplicatesOfTheElement = 1;
            while (right + 1 < n && nums[right] == nums[right + 1]) {
                ++countOfDuplicatesOfTheElement;
                ++right;
            }
            for (int i = 0; i < Math.min(2, countOfDuplicatesOfTheElement); ++i) {
                nums[left] = nums[right];
                ++left;
            }
            ++right;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 2, 2, 3 };
        System.out.println(new RemoveDuplicatesFromSortedArrayII().removeDuplicates(nums));
    }
}
