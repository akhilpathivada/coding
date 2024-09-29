/**
 * author: akhilpathivada
 * time: 29/09/24 13:50
 *
 * https://leetcode.com/problems/lexicographical-numbers/description/
 *
 */
package dfs;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {

    private void dfs(int num, int n, List<Integer> result) {
        if (num > n) {
            return;
        }
        result.add(num);
        for (int i = 0; i <= 9; ++i) {
            if (num * 10 + i > n) {
                break;
            }
            dfs(num * 10 + i, n, result);
        }
    }

    private List<Integer> lexicalOrder(int n) {
        final List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= 9; ++i) {
            dfs(i, n, result);
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 13;
        System.out.println(new LexicographicalNumbers().lexicalOrder(n));
    }
}
