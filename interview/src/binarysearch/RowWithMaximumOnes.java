/**
 * @author akhilpathivada
 * <p>
 * date : 28/12/23
 * time: 09:57
 *
 * https://www.codingninjas.com/studio/problems/row-with-maximum-1-s_1112656
 *
 * Time Complexity: O(n * log(m))
 * Space Complexity: O(1)
 */
package binarysearch;

import java.util.ArrayList;

public class RowWithMaximumOnes {

    private int findStartingIndexOfOne(int[] nums, int target) {
        int startingIndex = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int midpoint = start + (end - start) / 2;
            if (nums[midpoint] >= target) {
                end = midpoint - 1;
            } else {
                start = midpoint + 1;
            }
            // even if we find the target : we still look for it's starting index
            if (nums[midpoint] == target) {
                startingIndex = midpoint;
            }
        }
        return startingIndex == -1 ? nums.length : startingIndex;
    }

    public int rowMaxOnes(ArrayList<ArrayList<Integer>> mat, int n, int m) {
        int maxCount = Integer.MIN_VALUE;
        int index = -1;
        for (int row = 0; row < n; ++row) {
            int count = m - findStartingIndexOfOne(mat.get(row).stream().mapToInt(i -> i).toArray(), 1);
            if (count > maxCount) {
                maxCount = count;
                index = row;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int n = 3;
        int m = 3;
        int[][] matrix = { { 1, 1, 1 }, { 0, 0, 1 }, { 0, 0, 0 } };
        ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
        for (int[] row : matrix) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int element : row) {
                list.add(element);
            }
            mat.add(list);
        }
        System.out.println(new RowWithMaximumOnes().rowMaxOnes(mat, n, m));
    }
}
