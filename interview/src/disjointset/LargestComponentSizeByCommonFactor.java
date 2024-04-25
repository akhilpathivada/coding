package disjointset;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Date 25/04/24
 * Time 07:55
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/largest-component-size-by-common-factor/description/
 *
 */
public class LargestComponentSizeByCommonFactor {

    private static final class DisjointSet {

        private final int[] size; // stores size

        private final int[] parent; // stores parent of each node

        private DisjointSet(int n) {
            // create with n + 1 size: so that it would be useful for 0-indexed and 1-indexed as well
            size = new int[n + 1];
            parent = new int[n + 1];
            // initially every node itself is a disjoint set
            // so parent of a node is itself and also
            // the size of every node is 1
            for (int i = 0; i <= n; ++i) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        // to find the ultimate parent of a node
        // and do "path compression"
        private int findUltimateParent(int node) {
            // this the ultimate parent (root)
            if (parent[node] == node) {
                return node;
            }
            return parent[node] = findUltimateParent(parent[node]);
        }

        private void unionBySize(int u, int v) {
            int ultimateParentOfU = findUltimateParent(u);
            int ultimateParentOfV = findUltimateParent(v);
            // if both are already in same set
            if (ultimateParentOfU == ultimateParentOfV) {
                return;
            }
            if (size[ultimateParentOfU] < size[ultimateParentOfV]) {
                parent[ultimateParentOfU] = ultimateParentOfV;
                size[ultimateParentOfV] += size[ultimateParentOfU];
            } else {
                parent[ultimateParentOfV] = ultimateParentOfU;
                size[ultimateParentOfU] += size[ultimateParentOfV];
            }
        }
    }

    private int largestComponentSize(int[] nums) {
        final int maxNumber = Arrays.stream(nums).max().getAsInt();
        final DisjointSet disjointSet = new DisjointSet(maxNumber);
        for (int num : nums) {
            for (int i = 2; i * i <= num; ++i) {
                if (num % i == 0) {
                    disjointSet.unionBySize(i, num);
                    disjointSet.unionBySize(num / i, num);
                }
            }
        }
        final Map<Integer, Integer> rootToChildCountMap = new HashMap<>();
        int result = Integer.MIN_VALUE;
        for (int num : nums) {
            int root = disjointSet.findUltimateParent(num);
            rootToChildCountMap.put(root, rootToChildCountMap.getOrDefault(root, 0) + 1);
            result = Math.max(result, rootToChildCountMap.get(root));
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4, 6, 15, 35};
        System.out.println(new LargestComponentSizeByCommonFactor().largestComponentSize(nums));
    }
}
