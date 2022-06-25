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
		int i = 0, j = nums.length - 1, k = 0;
		while (i < j) {
			if (nums[j] == val) {
				--j;
				++k;
			} else if (nums[i] == val && nums[j] != val) {
				nums[i] = nums[j];
				++i;
				--j;
				++k;
			} else {
				++i;
			}
		}
		if (nums[j] == val) {
			k++;
		}
		return nums.length - k;
	}
	public static void main(String[] args) {
		int[] nums = { 0, 1, 2, 2, 3, 0, 4, 2 };
		int val = 2;
		System.out.println(new RemoveElement().removeElement(nums, val));
	}
}
