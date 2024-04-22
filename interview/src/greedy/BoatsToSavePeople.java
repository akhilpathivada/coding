package greedy;

import java.util.Arrays;

/**
 * Date 19/04/24
 * Time 22:36
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/boats-to-save-people/description/
 *
 */
public class BoatsToSavePeople {

    private int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int boatsNeeded = 0;
        int left = 0;
        int right = people.length - 1;
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                ++left;
                --right;
            } else {
                --right;
            }
            ++boatsNeeded;
        }
        return boatsNeeded;
    }

    public static void main(String[] args) {
        int[] people = {5, 1, 4, 2};
        int limit = 6;
        System.out.println(new BoatsToSavePeople().numRescueBoats(people, limit));
    }
}
