/**
 * author: akhilpathivada
 * time: 08/06/24 08:11
 *
 * https://leetcode.com/problems/add-minimum-number-of-rungs/description/
 *
 */
package greedy;

public class AddMinimumNumberOfRungs {

    private int addRungs(int[] rungs, int dist) {
        int prev = 0;
        int rungsToAdd = 0;
        for (int rung : rungs) {
            rungsToAdd += (rung - prev - 1) / dist;
            prev = rung;
        }
        return rungsToAdd;
    }

    public static void main(String[] args) {
        int[] rungs = {1, 3, 5, 10};
        int dist = 2;
        System.out.println(new AddMinimumNumberOfRungs().addRungs(rungs, dist));
    }
}
