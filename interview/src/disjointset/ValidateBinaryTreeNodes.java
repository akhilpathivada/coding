/**
 * author: akhilpathivada
 * time: 22/05/24 13:16
 *
 * https://leetcode.com/problems/validate-binary-tree-nodes/description/
 *
 */
package disjointset;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ValidateBinaryTreeNodes { // unfinished

    private final class DisjointSet {

        private final int[] parent;

        public DisjointSet(int n) {
            parent = new int[n + 1];
            for (int i = 0; i <= n; ++i) {
                parent[i] = i;
            }
        }

        public int findUltimateParent(int node) {
            if (parent[node] == node) {
                return node;
            }
            return parent[node] = findUltimateParent(parent[node]);
        }

        public void union(int u, int v) {
            parent[v] = u;
        }
    }

    private boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        final DisjointSet disjointSet = new DisjointSet(n);
        for (int i = 0; i < n; i++) {
            int left = leftChild[i];
            int right = rightChild[i];
            int root = disjointSet.findUltimateParent(i);
            if (left != -1) {
                disjointSet.union(i, left);
                if (disjointSet.findUltimateParent(left) != root) {
                    System.out.println("left");
                    return false; // left node already has a parent
                }
            }
            if (right != -1) {
                disjointSet.union(i, right);
                System.out.println("disjointSet.findUltimateParent(right)" + disjointSet.findUltimateParent(right));
                if (disjointSet.findUltimateParent(right) != root) {
                    System.out.println("right");
                    return false; // right node already has a parent
                }
            }
            System.out.println(Arrays.toString(disjointSet.parent));
        }
        int root = disjointSet.findUltimateParent(0);
        for (int i = 1; i < n; i++) {
            if (disjointSet.findUltimateParent(i) != root) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 4;
        int[] leftChild = {1,-1,3,-1};
        int[] rightChild = {2,-1,-1,-1};
        System.out.println(new ValidateBinaryTreeNodes().validateBinaryTreeNodes(n, leftChild, rightChild));
    }
}
