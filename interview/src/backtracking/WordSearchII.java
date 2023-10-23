package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII {

    private void backtrack(char[][] board, List<String> result, Set<String> dict,boolean[][] visited, int i, int j) {
        // base case : see i, j shouldn't exceed the boundaries
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) {
            return;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                // assume the word starts with this cell
                // try all the combinations
                backtrack(board, new ArrayList<>(), new HashSet<>(Arrays.asList(words)), visited, i, j);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        char[][] board = { { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'C', 'S' },
                { 'A', 'D', 'E', 'E' }
        };
        String[] words = {"oath","pea","eat","rain"};
        System.out.println(new WordSearchII().findWords(board, words));
    }
}
