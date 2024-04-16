/**
 *
 * https://leetcode.com/problems/minimum-jumps-to-reach-home/description/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * */
package bfs;

import java.util.*;
import java.util.stream.Collectors;

public class MinimumJumpsToReachHome {

    private final static class State {
        private final int position;
        private final boolean cameFromBackward;

        public State(int position, boolean cameFromBackward) {
            this.position = position;
            this.cameFromBackward = cameFromBackward;
        }
    }

    private String getStringValue(State state) {
        return state.position + "," + state.cameFromBackward;
    }

    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        // create a forbit set
        Set<Integer> forbit = Arrays.stream(forbidden).boxed().collect(Collectors.toSet());
        // add the initial state as '0'
        Set<String> seen = new HashSet<>();
        seen.add(getStringValue(new State(0, false)));
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
                if (!forbit.contains(nextState.position) && nextState.position < 4000 && !seen.contains(getStringValue(nextState))) {
                    queue.offer(nextState);
                    seen.add(getStringValue(nextState));
                }
                // jump backward
                nextState = new State(current - b, true);
                // if the current state it didn't come through a backward jump
                if (!cameFromBackward && !forbit.contains(nextState.position) && nextState.position >= 0
                        && !seen.contains(getStringValue(nextState))) {
                    queue.offer(nextState);
                    seen.add(getStringValue(nextState));
                }
            }
            ++jumps;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] forbidden = {14, 4, 18, 1, 15};
        int a = 3, b = 15, x = 9;
        System.out.println(new MinimumJumpsToReachHome().minimumJumps(forbidden, a, b, x));
    }
}
