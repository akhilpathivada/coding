/**
 * author: akhilpathivada
 * time: 07/10/24 11:18
 *
 * https://leetcode.com/problems/destroying-asteroids/description/
 *
 */
package greedy.sorting;

import java.util.Arrays;

public class DestroyingAsteroids {

    private boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long currentMass = mass;
        for (int asteroid : asteroids) {
            if (asteroid > currentMass) {
                return false;
            }
            currentMass += asteroid;
        }
        return true;
    }

    public static void main(String[] args) {
        int mass = 10;
        int[] asteroids = {3, 9, 19, 5, 21};
        System.out.println(new DestroyingAsteroids().asteroidsDestroyed(mass, asteroids));
    }
}
