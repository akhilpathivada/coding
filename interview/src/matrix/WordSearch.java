/**
 * https://leetcode.com/problems/word-search/description/
 *
 * Time Complexity: O(M * N * 4^L) where L is length of the word
 * Space Complexity: O(M * N)
 * */
package matrix;

public class WordSearch {

    private boolean searchWord(final char[][] board, final boolean[][] visited,
                               final String word, final int index, final int i, final int j) {
        // the entire word id found
        if (index == word.length()) {
            return true;
        }
        // base case : see i, j shouldn't exceed the boundaries
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length ||
                word.charAt(index) != board[i][j] || visited[i][j]) {
            return false;
        }
        // mark the current cell as visited
        visited[i][j] = true;
        // check in all the adjacent directions
        if (searchWord(board, visited, word, index + 1, i + 1, j) ||
                searchWord(board, visited, word, index + 1, i - 1, j) ||
                searchWord(board, visited, word, index + 1, i, j - 1) ||
                searchWord(board, visited, word, index + 1, i, j + 1)) {
            return true;
        }
        // mark it as unvisited, since because the word is not found with this cell
        visited[i][j] = false;
        return false;
    }

    private boolean exist(char[][] board, String word) {
        final int m = board.length;
        final int n = board[0].length;
        // track whether a cell is already visited or not
        final boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                // always assume the word starts with this cell
                if (word.charAt(0) == board[i][j] && searchWord(board, visited, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = { { 'A', 'B', 'C', 'E' },
                           { 'S', 'F', 'C', 'S' },
                           { 'A', 'D', 'E', 'E' }
        };
        String word = "SEE";
        System.out.println(new WordSearch().exist(board, word));
    }
}
