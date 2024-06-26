/**
 * Date 01/05/2022
 *
 * @author akhilpathivada
 *
 * Space complexity for segment tree is O(4 * n)
 * Time complexity to create segment tree is O(n * log(n))
 * Time complexity to update value is O(log(n))
 * Time complexity to get range min/sum is O(log(n))
 */
package segmenttree.base;

public abstract class SegmentTree {

        public final int[] st; // this array stores nodes of the segment tree

        public SegmentTree(int n) {
                // compute height of segment tree
                int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
                // size of segment segment
                int size = 2 * (int) Math.pow(2, x) - 1;
                st = new int[size];
        }

        public int[] getSegmentTree() {
                return st;
        }

        public abstract int constructSegmentTree(int[] nums, int ss, int se, int index);

}
