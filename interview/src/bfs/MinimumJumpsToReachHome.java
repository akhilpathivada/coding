/**
 *
 * https://leetcode.com/problems/minimum-jumps-to-reach-home/description/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * */
package bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinimumJumpsToReachHome {

    private static class State {
        private final int position;
        private final boolean cameFromBackward;

        public State(int position, boolean cameFromBackward) {
            this.position = position;
            this.cameFromBackward = cameFromBackward;
        }
    }

    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        // form a hashset to easily check whether a state is forbit or not
        Set<Integer> forbit = new HashSet<>();
        for (int forbid : forbidden) {
            forbit.add(forbid);
        }
        // add the first state as '0'
        Set<State> seen = new HashSet<>();
        seen.add(new State(0, false));
        // add the first state to Queue
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(0, false));
        // answer
        int jumps = 0;
        // do BFS
        while (!queue.isEmpty()) {
            int n = queue.size();
            // For any node: BFS over both it's possible states
            while (n-- > 0) {
                State state = queue.poll();
                // the current state
                int current = state.position;
                boolean cameFromBackward = state.cameFromBackward;
                // found home
                if (current == x) {
                    return jumps;
                }
                // jump forward
                State nextState = new State(current + a, false);
                if (!forbit.contains(nextState.position) && nextState.position < 4000 && !seen.contains(nextState)) {
                    queue.offer(nextState);
                    seen.add(nextState);
                }
                // jump backward
                nextState = new State(current - b, true);
                // if the current state it didn't come through a backward jump
                if (!cameFromBackward && !forbit.contains(nextState.position) && nextState.position >= 0
                        && !seen.contains(nextState)) {
                    queue.offer(nextState);
                    seen.add(nextState);
                }
            }
            ++jumps;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] forbidden = { 8,3,16,6,12,20 };
        int a = 15, b = 13, x = 11;
        System.out.println(new MinimumJumpsToReachHome().minimumJumps(forbidden, a, b, x));
    }
}
