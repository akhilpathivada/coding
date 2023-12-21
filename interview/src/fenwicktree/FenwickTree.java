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

public class FenwickTree {

    private int[] constructTree(int[] nums) {
        int n = nums.length;
        int[] binaryIndexedTree = new int[n + 1];
        return binaryIndexedTree;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
        FenwickTree fenwickTree = new FenwickTree();
        int[] binaryIndexedTree = fenwickTree.constructTree(nums);

    }
}
