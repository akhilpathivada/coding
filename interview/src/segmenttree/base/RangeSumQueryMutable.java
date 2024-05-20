/**
 * https://leetcode.com/problems/range-sum-query-mutable/description/
 *
 * Time Complexity for segment tree construction is O(n).
 * There are total 2n - 1 nodes, and value of every node is calculated only once in tree construction.
 *
 * Time Complexity: to query is O(log(n)).
 * To query a range minimum, we process at most two nodes at every level and number of levels is O(log(n)).
 * Space Complexity: O(n), since n extra space has been taken.
 *
 * */
package segmenttree.base;

public class RangeSumQueryMutable {

    private final int[] nums;

    private final SegmentTreeForRangeSumQuery segmentTreeForRangeSumQuery;

    public RangeSumQueryMutable(int[] nums) {
        this.nums = nums;
        this.segmentTreeForRangeSumQuery = new SegmentTreeForRangeSumQuery(nums.length);
    }

    private void updateUtil(int[] st, int ss, int se, int index, int diff, int si) {
        // base case
        if (index > se || index < ss) {
            return;
        }
        st[si] += diff;
        if (se == ss) {
            return;
        }
        int mid = ss + (se - ss) / 2;
        updateUtil(st, ss, mid, index, diff, 2 * si + 1);
        updateUtil(st, mid + 1, se, index, diff, 2 * si + 2);
    }

    public void update(int index, int val) {
        int n = nums.length;
        // base case
        if (index < 0 || index >= n) {
            return;
        }
        // Get the difference between new value and old value
        int diff = val - nums[index];
        // Update the value in array
        nums[index] = val;
        updateUtil(segmentTreeForRangeSumQuery.getSegmentTree(), 0, n - 1, index, diff, 0);
    }

    private int sumRangeUtil(int[] st, int ss, int se, int qs, int qe, int index) {
        // base case
        if (qs <= ss && qe >= se) {
            return st[index];
        }
        if (qs > se || qe < ss) {
            return 0;
        }
        int mid = ss + (se - ss) / 2;
        return sumRangeUtil(st, ss, mid, qs, qe, 2 * index + 1) +
                sumRangeUtil(st, mid + 1, se, qs, qe, 2 * index + 2);
    }

    public int sumRange(int left, int right) {
        int n = nums.length;
        if (left < 0 || right >= n) {
            return -1;
        }
        segmentTreeForRangeSumQuery.constructSegmentTree(nums, 0, n - 1, 0);
        return sumRangeUtil(segmentTreeForRangeSumQuery.getSegmentTree(), 0, n - 1, left, right, 0);
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 5 };
        RangeSumQueryMutable rsqm = new RangeSumQueryMutable(nums);
        System.out.println(rsqm.sumRange(0, 2)); // return 1 + 3 + 5 = 9
        rsqm.update(1, 2); // should become nums = [1, 2, 5]
        System.out.println(rsqm.sumRange(0, 2)); // return 1 + 2 + 5 = 8
    }
}
