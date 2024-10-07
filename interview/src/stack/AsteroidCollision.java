/**
 * author: akhilpathivada
 * time: 07/10/24 09:51
 *
 * https://leetcode.com/problems/asteroid-collision/description/
 *
 */
package stack;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {

    private int[] asteroidCollision(int[] asteroids) {
        final Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                stack.push(asteroid);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -asteroid) {
                    stack.pop();
                }
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroid);
                }
                if (stack.peek() == -asteroid) {
                    stack.pop();
                }
            }
        }
        return stack.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[] asteroids = {-2, -1, 1, 2};
//        int[] asteroids = {5,10,-5};
        System.out.println(Arrays.toString(new AsteroidCollision().asteroidCollision(asteroids)));
    }
}
