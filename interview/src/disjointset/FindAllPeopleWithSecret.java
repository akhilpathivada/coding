/**
 * author: akhilpathivada
 * time: 10/06/24 14:40
 */
package disjointset;

import java.util.*;

public class FindAllPeopleWithSecret {

    private final class DisjointSet {

        private final int[] size;

        private final int[] parent;

        private DisjointSet(int n) {
            size = new int[n + 1];
            parent = new int[n + 1];
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

        private boolean isConnected(int u, int v) {
            return findUltimateParent(u) == findUltimateParent(v);
        }

        private void reset(int u) {
            parent[u] = u;
            size[u] = 1;
        }
    }

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, (a, b) -> a[2] - b[2]);
        final DisjointSet disjointSet = new DisjointSet(n);
        disjointSet.unionBySize(0, firstPerson);
        int i = 0;
        while (i < meetings.length) {
            int currentTime = meetings[i][2];
            Set<Integer> pool = new HashSet<>();
            while (i < meetings.length && currentTime == meetings[i][2]) {
                int u = meetings[i][0];
                int v = meetings[i][1];
                disjointSet.unionBySize(u, v);
                pool.add(u);
                pool.add(v);
                ++i;
            }
            for (int p : pool) {
                if (!disjointSet.isConnected(p, 0)) {
                    disjointSet.reset(p);
                }
            }
        }
        final List<Integer> result = new ArrayList<>();
        for (i = 0; i <= n; ++i) {
            if (disjointSet.isConnected(i, 0)) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 6;
        int firstPerson = 1;
        int[][] meetings = {{1, 2, 5}, {2, 3, 8}, {1, 5, 10}};
        System.out.println(new FindAllPeopleWithSecret().findAllPeople(n, meetings, firstPerson));
    }
}
