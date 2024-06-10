/**
 * author: akhilpathivada
 * time: 10/06/24 17:23
 *
 * https://leetcode.com/problems/find-in-mountain-array/description/
 *
 */
package binarysearch;

public class FindInMountainArray {

    private static final class MountainArray {

        private final int[] arr;

        private MountainArray(int[] a) {
            arr = a;
        }

        private int get(int k) {
            return arr[k];
        }

        private int length() {
            return arr.length;
        }
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        // find the peak
        int start = 0;
        int end = mountainArr.length() - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            // if the mid is in a decreasing part
            // this might be the answer
            // now go to left if there exist any greater value
            if (mountainArr.get(mid) > mountainArr.get(mid + 1)) {
                end = mid;
            } else { // you are in ascending order
                // go to right if there exist greater value
                start = mid + 1;
            }
        }
        int peak = start; // start would be our peak
        // find target in the left of peak
        start = 0;
        end = peak;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mountainArr.get(mid) < target) {
                start = mid + 1;
            } else if (mountainArr.get(mid) > target) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        // find target in the right of peak
        start = peak;
        end = mountainArr.length() - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mountainArr.get(mid) > target) {
                start = mid + 1;
            } else if (mountainArr.get(mid) < target) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 3, 1};
        int target = 3;
        System.out.println(new FindInMountainArray().findInMountainArray(target, new MountainArray(array)));
    }
}
