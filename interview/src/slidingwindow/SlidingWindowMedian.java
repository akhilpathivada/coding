/**
 *
 * https://leetcode.com/problems/sliding-window-median/
 *
 * Time Complexity: O((N-K)*log K + N*log K) = O(N * log K)
 * Space Complexity: O(K)
 * */
package slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class SlidingWindowMedian {

    private double getMedian(int[] nums, TreeSet<Integer> smallNumbersSet, TreeSet<Integer> bigNumbersSet) {
        if (smallNumbersSet.size() == bigNumbersSet.size()) {
            return ((double) nums[smallNumbersSet.first()] + nums[bigNumbersSet.first()]) / 2;
        }
        return nums[smallNumbersSet.first()];
    }

    private void addElementToSet(TreeSet<Integer> smallNumbersSet, TreeSet<Integer> bigNumbersSet, int index) {
        smallNumbersSet.add(index);
        bigNumbersSet.add(smallNumbersSet.pollFirst());
        if (smallNumbersSet.size() < bigNumbersSet.size()) {
            smallNumbersSet.add(bigNumbersSet.pollFirst());
        }
    }

    private void removeElementFromSet(TreeSet<Integer> smallNumbersSet, TreeSet<Integer> bigNumbersSet, int index) {
        if (bigNumbersSet.contains(index)) {
            bigNumbersSet.remove(index);
            if (smallNumbersSet.size() == bigNumbersSet.size() + 2) {
                bigNumbersSet.add(smallNumbersSet.pollFirst());
            }
        } else {
            smallNumbersSet.remove(index);
            if (smallNumbersSet.size() < bigNumbersSet.size()) {
                smallNumbersSet.add(bigNumbersSet.pollFirst());
            }
        }
    }

    private double[] medianSlidingWindow(int[] nums, int k) {
        // base case
        if (nums == null || k <= 0) {
            throw new IllegalArgumentException("Input is invalid");
        }

        List<Double> medians = new ArrayList<>();
        Comparator<Integer> comparator = (a, b) -> (nums[a] != nums[b] ?
                Integer.compare(nums[a], nums[b]) :
                Integer.compare(a, b));
        // smallNumbersSet will always contain the first set of numbers (smaller) of window k
        TreeSet<Integer> smallNumbersSet = new TreeSet<>(comparator.reversed());
        // bigNumbersSet will contain the second set of numbers (larger) of window k
        TreeSet<Integer> bigNumbersSet = new TreeSet<>(comparator);
        // iterate over all windows
        for (int i = 0; i < nums.length; ++i) {
            if (i >= k) {
                removeElementFromSet(smallNumbersSet, bigNumbersSet, i - k);
            }
            addElementToSet(smallNumbersSet, bigNumbersSet, i);
            if (i >= k - 1) {
                medians.add(getMedian(nums, smallNumbersSet, bigNumbersSet));
            }
        }
        return medians.stream().mapToDouble(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        System.out.println(Arrays.toString(new SlidingWindowMedian().medianSlidingWindow(nums, k)));
    }
}
