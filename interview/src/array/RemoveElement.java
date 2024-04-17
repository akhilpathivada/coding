/**
 * https://leetcode.com/problems/remove-element/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 * */
package array;

public class RemoveElement {
	private int removeElement(int[] nums, int val) {
		if (nums.length == 0) {
			return 0;
		}
		int i = 0;
		// move elements which are not equal to val to beginning
		for (int num : nums) {
			if (num != val) {
				nums[i++] = num;
			}
		}
		return i;
	}
	public static void main(String[] args) {
		int[] nums = { 0, 1, 2, 2, 3, 0, 4, 2 };
		int val = 2;
		System.out.println(new RemoveElement().removeElement(nums, val));
	}
}
