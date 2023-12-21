/**
 * Date 01/05/2022
 *
 * @author akhilpathivada
 */
package segmenttree;

public abstract class SegmentTree {

        public final int[] nodes; // This array stores Segment Tree nodes

        private final int size; // Size of Segment Tree

        public SegmentTree(int n) {
                // compute height of segment tree
                int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
                size = 2 * (int) Math.pow(2, x) - 1;
                nodes = new int[size];
        }

        public int[] getNodes() {
                return nodes;
        }

        public abstract int constructSegmentTree(int[] nums, int ss, int se, int index);

}
