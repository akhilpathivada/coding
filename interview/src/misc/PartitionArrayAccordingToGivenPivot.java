/**
 * date 07/08/24 15:16
 *
 * @author akhil.p
 *
 * https://leetcode.com/problems/partition-array-according-to-given-pivot/description/
 *
 */
package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartitionArrayAccordingToGivenPivot {

    private int[] pivotArray(int[] nums, int pivot) {
        final List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            if (num < pivot) {
                result.add(num);
            }
        }
        for (int num : nums) {
            if (num == pivot) {
                result.add(num);
            }
        }
        for (int num : nums) {
            if (num > pivot) {
                result.add(num);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[] nums = {9, 12, 5, 10, 14, 3, 10};
        int pivot = 10;
        System.out.println(Arrays.toString(new PartitionArrayAccordingToGivenPivot().pivotArray(nums, pivot)));
    }
}
