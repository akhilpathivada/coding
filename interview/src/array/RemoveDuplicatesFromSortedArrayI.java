/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 * */
package array;

public class RemoveDuplicatesFromSortedArrayI {
	private int removeDuplicates(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int i = 0;
		for (int j = 1; j < nums.length; ++j) {
			if (nums[i] != nums[j]) {
				nums[++i] = nums[j];
			}
		}
		return i + 1;
	}
	public static void main(String[] args) {
		int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
		System.out.println(new RemoveDuplicatesFromSortedArrayI().removeDuplicates(nums));
	}
}
