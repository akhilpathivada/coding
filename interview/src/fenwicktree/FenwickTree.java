/**
 *
 * A Fenwick tree or binary indexed tree is a data structure providing efficient methods
 * for calculation and manipulation of the prefix sums of a table of values.
 *
 * Space complexity for fenwick tree is O(n)
 * Time complexity to create fenwick tree is O(n * log(n))
 * Time complexity to update value is O(log(n))
 * Time complexity to get prefix sum is O(log(n))
 *
 * http://www.geeksforgeeks.org/binary-indexed-tree-or-fenwick-tree-2/
 * https://www.topcoder.com/community/data-science/data-science-tutorials/binary-indexed-trees/
 * http://en.wikipedia.org/wiki/Fenwick_tree
 *
 * */
package fenwicktree;

import java.util.Arrays;

public class FenwickTree {

    private final int[] binaryIndexedTree;

    public FenwickTree(int n) {
        // binaryIndexedTree should be of size: n + 1
        binaryIndexedTree = new int[n + 1];
        // initialize binaryIndexedTree[] as 0
        Arrays.fill(binaryIndexedTree, 0);
    }

    /**
     * start from (index + 1) if you're updating index in original array. Keep adding this value
     * for next node till you reach outside range of tree
     */
    public void updateBinaryIndexedTree(int index, int value) { // O(log(n))
        while (index < binaryIndexedTree.length) {
            binaryIndexedTree[index] += value;
            index = getNext(index);
        }
    }

    /**
     * start from index + 1 if you want prefix sum 0 to index. Keep adding value
     * till you reach 0
     */
    public int getSum(int index) { // O(log(n))
        index = index + 1;
        int sum = 0;
        while (index > 0) {
            sum += binaryIndexedTree[index];
            index = getParent(index);
        }
        return sum;
    }

    /**
     * to get parent:
     * 1) 2's complement of index
     * 2) AND this with original index
     * 3) subtract it from original index
     *
     * Example:
     * input: 1010 -> 10
     * output: 1000 -> 8
     * means, parent(10) is node 8
     */
    private int getParent(int index) { // O(1)
        return index - (index & -index);
    }

    /**
     * to get next:
     * 1) 2's complement of index
     * 2) AND this with original index
     * 3) add it to original index
     *
     * Example:
     * input: 1000
     * output: 1010
     * means, next(8) is node 10
     */
    private int getNext(int index){ // O(1)
        return index + (index & -index);
    }

    /**
     * constructing tree is like updating Fenwick tree for every value in array
     */
    public void constructTree(int[] nums) { // O(n) * O(log(n))
        int n = nums.length;
        for (int i = 1; i <= n; ++i) {
            // store the actual values in binaryIndexedTree[] using updateBinaryIndexedTree()
            updateBinaryIndexedTree(i, nums[i - 1]);
        }
        System.out.println(Arrays.toString(binaryIndexedTree));
    }

    public static void main(String[] args) {
        int[] nums = { 2, 1, 1, 3, 2, 3, 4, 5, 6, 7, 8, 9 };
        FenwickTree fenwickTree = new FenwickTree(nums.length);
        // construct fenwick tree from given array
        fenwickTree.constructTree(nums);
        System.out.println("Sum of elements in arr[0..5] is = "+ fenwickTree.getSum(5));
        // update operation
        fenwickTree.updateBinaryIndexedTree(3, 6);
        System.out.println("Sum of elements in arr[0..5] is = "+ fenwickTree.getSum(5));
    }
}
