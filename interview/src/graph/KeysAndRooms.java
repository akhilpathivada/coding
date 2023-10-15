/**
 * https://leetcode.com/problems/keys-and-rooms/editorial/
 *
 * Time Complexity: O(N + E), where N is the number of rooms, and E is the total number of keys.
 * Space Complexity: O(N) in additional space complexity, to store stack and seen.
 * */
package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class KeysAndRooms {

    private boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        Stack<Integer> stack = new Stack<>();
        visited[0] = true;
        stack.push(0);

        while (!stack.isEmpty()) {
            // entered into the room
            int room = stack.pop();
            // for every key we have in the room
            for (int key : rooms.get(room)) {
                if (!visited[key]) {
                    // mark that we entered into the room
                    visited[key] = true;
                    // add the key to the TODO list
                    stack.push(key);
                }
            }
        }
        // if we find any room unvisited
        for (boolean _visited : visited) {
            if (!_visited) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(new ArrayList<>(Arrays.asList(1)));
        rooms.add(new ArrayList<>(Arrays.asList(2)));
        rooms.add(new ArrayList<>(Arrays.asList(3)));
        rooms.add(new ArrayList<>());
        System.out.println(new KeysAndRooms().canVisitAllRooms(rooms));
    }
}
