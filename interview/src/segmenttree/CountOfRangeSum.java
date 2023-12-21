/**
 * https://leetcode.com/problems/count-of-range-sum/description/
 * */
package segmenttree;

public class CountOfRangeSum {

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

    private int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        int countOfSumsInRange = 0;
        SegmentTreeForRangeSumQuery segmentTreeForRangeSumQuery = new SegmentTreeForRangeSumQuery(n);
        segmentTreeForRangeSumQuery.constructSegmentTree(nums, 0, n - 1, 0);
        int[] st = segmentTreeForRangeSumQuery.getNodes();
        return countOfSumsInRange;
    }

    private int _countRangeSum(int[] nums, int lower, int upper) { // O((N ^ 2) * log(N))
        int n = nums.length;
        int countOfSumsInRange = 0;
        SegmentTreeForRangeSumQuery segmentTreeForRangeSumQuery = new SegmentTreeForRangeSumQuery(n);
        segmentTreeForRangeSumQuery.constructSegmentTree(nums, 0, n - 1, 0);
        int[] st = segmentTreeForRangeSumQuery.getNodes();
        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                int sum = sumRangeUtil(st, 0, n - 1, i, j, 0);
                if (sum >= lower && sum <= upper) {
                    ++countOfSumsInRange;
                }
            }
        }
        return countOfSumsInRange;
    }

    public static void main(String[] args) {
        int[] nums = { -2, 5, -1 };
        int lower = -2, upper = 2;
        System.out.println(new CountOfRangeSum().countRangeSum(nums, lower, upper));
    }
}
