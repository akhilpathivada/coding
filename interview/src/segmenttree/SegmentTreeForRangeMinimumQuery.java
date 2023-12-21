/**
 *
 * Time Complexity for segment tree construction is O(n).
 * There are total 2n - 1 nodes, and value of every node is calculated only once in tree construction.
 *
 * */
package segmenttree;

public class SegmentTreeForRangeMinimumQuery extends SegmentTree {

    public SegmentTreeForRangeMinimumQuery(int n) {
        super(n);
    }

    @Override
    public int constructSegmentTree(int[] arr, int ss, int se, int index) {
        // If there is one element in array, store it in current
        //  node of segment tree and return
        if (ss == se) {
            nodes[index] = arr[ss];
            return arr[ss];
        }
        int mid = ss + (se - ss) / 2;
        // If there are more than one element, then recur for left and
        // right subtrees and store the minimum of two values in this node
        nodes[index] = Math.min(constructSegmentTree(arr, ss, mid, index * 2 + 1),
                constructSegmentTree(arr, mid + 1, se, index * 2 + 2));
        return nodes[index];
    }
}
