/**
 * @author akhilpathivada
 * <p>
 * date : 25/12/23
 * time: 16:35
 *
 * https://leetcode.com/problems/kth-missing-positive-number/description/
 * https://www.codingninjas.com/studio/problems/kth-missing-element_893215
 *
 * Time Complexity: O(log(n))
 * Space Complexity: O(1)
 */
package binarysearch;

public class KthMissingPositiveNumber {

    private int findKthPositive(int[] arr, int k) {
        int low = 1;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int missing = arr[mid] - (mid + 1);
            if (missing < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low + k;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 4, 7, 11 };
        int k = 5;
        System.out.println(new KthMissingPositiveNumber().findKthPositive(arr, k));
    }
}
