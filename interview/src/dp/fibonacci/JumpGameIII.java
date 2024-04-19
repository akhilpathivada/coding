package dp.fibonacci;

/**
 * Date 19/04/24
 * Time 21:42
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/jump-game-iii/description/
 *
 */
public class JumpGameIII {

    private boolean canReach(final int[] arr, final boolean[] visited, int index) {
        if (index < 0 || index >= arr.length || visited[index]) {
            return false;
        }
        if (arr[index] == 0) {
            return true;
        }
        visited[index] = true;
        return canReach(arr, visited, index + arr[index]) || canReach(arr, visited, index - arr[index]);
    }

    private boolean canReach(int[] arr, int start) {
        return canReach(arr, new boolean[arr.length], start);
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 3, 0, 3, 1, 2};
        int start = 5;
        System.out.println(new JumpGameIII().canReach(arr, start));
    }
}
