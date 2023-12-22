package fenwicktree;

public class RangeSumQueryMutable {

    private final int[] nums;

    private final FenwickTree fenwickTree;

    public RangeSumQueryMutable(int[] nums) {
        this.nums = nums;
        this.fenwickTree = new FenwickTree(nums.length);
        this.fenwickTree.constructTree(nums);
    }

    public void update(int index, int value) {
        // base case
        if (index < 0 || index >= nums.length) {
            return;
        }
        fenwickTree.updateBinaryIndexedTree(index, value - nums[index]);
    }

    public int sumRange(int left, int right) {
        // base case
        if (left < 0 || right >= nums.length) {
            return -1;
        }
        return fenwickTree.getSum(right) - fenwickTree.getSum(left - 1);
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 5 };
        RangeSumQueryMutable rsqm = new RangeSumQueryMutable(nums);
        System.out.println(rsqm.sumRange(0, 2)); // return 1 + 3 + 5 = 9
        rsqm.update(1, 2); // should become nums = [1, 2, 5]
        System.out.println(rsqm.sumRange(0, 2)); // return 1 + 2 + 5 = 8
    }
}
