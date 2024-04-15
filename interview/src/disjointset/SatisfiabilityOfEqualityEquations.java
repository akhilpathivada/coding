package disjointset;

/**
 * Date 15/04/24
 * Time 09:15
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/satisfiability-of-equality-equations/description/
 *
 */
public class SatisfiabilityOfEqualityEquations {

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

    private boolean equationsPossible(String[] equations) {
        DisjointSet disjointSet = new DisjointSet(26);
        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                disjointSet.unionBySize(equation.charAt(0) - 'a', equation.charAt(3) - 'a');
            }
        }
        for (String equation : equations) {
            if (equation.charAt(1) == '!' &&
                    disjointSet.findUltimateParent(equation.charAt(0) - 'a')
                            == disjointSet.findUltimateParent(equation.charAt(3) - 'a')) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] equations = {"a==b", "c==d", "a==c", "a!=d"};
        System.out.println(new SatisfiabilityOfEqualityEquations().equationsPossible(equations));
    }
}
