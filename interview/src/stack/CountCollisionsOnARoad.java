/**
 * author: akhilpathivada
 * time: 07/10/24 10:52
 *
 * https://leetcode.com/problems/count-collisions-on-a-road/description/
 *
 */
package stack;

import java.util.Stack;

public class CountCollisionsOnARoad {

    public int countCollisions_2(String directions) {
        int collisions = 0;
        char prev = directions.charAt(0);  // Track the previous state
        for (int i = 1; i < directions.length(); ++i) {
            char current = directions.charAt(i);
            if (prev == 'R' && current == 'L') { // When 'R' collides with 'L', both change to 'S'
                collisions += 2;
                prev = 'S';
            } else if (prev == 'S' && current == 'L') { // When 'S' collides with 'L', 'L' changes to 'S'
                collisions += 1;
                prev = 'S';
            } else if (prev == 'R' && current == 'S') { // When 'R' collides with 'S', 'R' changes to 'S'
                collisions += 1;
                prev = 'S';
            } else { // No collision, just update the previous state
                prev = current;
            }
        }
        return collisions;
    }

    private int countCollisions(String directions) {
        final Stack<Character> stack = new Stack<>();
        int collisions = 0;
        stack.push(directions.charAt(0));
        for (int i = 1; i < directions.length(); ++i) {
            char current = directions.charAt(i);
            if ((stack.peek() == 'R') && current == 'L') {
                collisions += 2;
                stack.pop();
                current = 'S';
            } else if (stack.peek() == 'S' && current == 'L') {
                collisions += 1;
                current = 'S';
            }
            while (!stack.isEmpty() && (stack.peek() == 'R' && current == 'S')) {
                collisions += 1;
                stack.pop();
            }
            stack.push(current);
        }
        return collisions;
    }

    public static void main(String[] args) {
        String directions = "RLRSLL";
        System.out.println(new CountCollisionsOnARoad().countCollisions(directions));
    }
}
