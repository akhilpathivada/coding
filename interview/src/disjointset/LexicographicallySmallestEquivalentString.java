package disjointset;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Date 24/04/24
 * Time 18:14
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/lexicographically-smallest-equivalent-string/description/
 */
public class LexicographicallySmallestEquivalentString {

    private static final class DisjointSet {

        private final int[] parent;

        private final int[] size;

        private DisjointSet(int n) {
            parent = new int[n + 1];
            size = new int[n + 1];
            for (int i = 0; i <= n; ++i) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        private int findUltimateParent(int node) {
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

    private String smallestEquivalentString(String s1, String s2, String baseStr) {
        final int n = s1.length();
        final DisjointSet disjointSet = new DisjointSet(26);
        for (int i = 0; i < n; ++i) {
            int u = s1.charAt(i) - 'a';
            int v = s2.charAt(i) - 'a';
            if (disjointSet.findUltimateParent(u) != disjointSet.findUltimateParent(v)) {
                disjointSet.unionBySize(u, v);
            }
        }
        // traverse through all the connected components and form a map
        final Map<Character, PriorityQueue<Character>> map = new HashMap<>();
        for (int i = 0; i <= 26; ++i) {
            char root = (char) (disjointSet.findUltimateParent(i) + 'a');
            map.computeIfAbsent(root, m -> new PriorityQueue<>()).add((char) (i + 'a'));
        }
        final StringBuilder result = new StringBuilder();
        // iterate over base str to compute result
        for (int i = 0; i < baseStr.length(); ++i) {
            char root = (char) (disjointSet.findUltimateParent(baseStr.charAt(i) - 'a') + 'a');
            result.append(map.get(root).peek());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s1 = "parker", s2 = "morris", baseStr = "parser";
        System.out.println(new LexicographicallySmallestEquivalentString().smallestEquivalentString(s1, s2, baseStr));
    }
}
