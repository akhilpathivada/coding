/**
 * author: akhilpathivada
 * time: 23/05/24 18:15
 *
 * https://leetcode.com/problems/assign-cookies/description/
 *
 */
package greedy;

import java.lang.reflect.Array;
import java.util.Arrays;

public class AssignCookies {

    private int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int contentChildren = 0;
        int i = g.length - 1;
        int j = s.length - 1;
        while (i >= 0 && j >= 0) {
            if (g[i] <= s[j]) {
                ++contentChildren;
                --i;
                --j;
            } else if (g[i] > s[j]) {
                --i;
            } else {
                --j;
            }
        }
        return contentChildren;
    }

    public static void main(String[] args) {
        int[] g = {1, 2};
        int[] s = {1, 2, 3};
        System.out.println(new AssignCookies().findContentChildren(g, s));
    }
}
