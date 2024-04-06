package dp;

import bfs.NumberOfEnclaves;

import java.util.Arrays;

/**
 * Date 06/04/24
 *
 * @author akhilpathivada
 */
public class test {

    private boolean isValidCell(int r, int c, int m, int n) {
        return r >= 0 && r < m && c >= 0 && c < n;
    }

    private void fillGuardSightWithBlockers(char[][] mat, int r, int c, int m, int n, char direction) {
        while (isValidCell(r, c, m, n)) {
            mat[r][c] = 'X';
            if (direction == '^') {
                --r;
            } else if (direction == 'v') {
                ++r;
            } else if (direction == '<') {
                --c;
            } else {
                ++c;
            }
            if (isValidCell(r, c, m, n) && (mat[r][c] == '^' || mat[r][c] == 'v' || mat[r][c] == '<' || mat[r][c] == '>')) {
                break;
            }
        }
    }
    
    private boolean canReach(char[][] mat, int r, int c, int m, int n) {
        if ((r == m - 1) && (c == n - 1)) {
            return true;
        }
        // mark as visited
        mat[r][c] = '$';
        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        for (int[] direction : directions) {
            int nrow = r + direction[0];
            int ncol = c + direction[1];
            if (isValidCell(nrow, ncol, m, n)
                    && mat[nrow][ncol] != 'X' && mat[nrow][ncol] != '$') {
                if (canReach(mat, nrow, ncol, m, n)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean solution(String[] matrix) {
        int m = matrix.length;
        int n = matrix[0].length();
        char[][] mat = new char[m][n];
        for (int i = 0; i < m; ++i) {
            String s = matrix[i];
            for (int j = 0; j < s.length(); ++j) {
                mat[i][j] = s.charAt(j);
            }
        }

        System.out.println(Arrays.deepToString(mat));
        
        for (int r = 0; r < m; ++r) {
            for (int c = 0; c < n; ++c) {
                if (mat[r][c] == '^' || mat[r][c] == 'v' || mat[r][c] == '<' || mat[r][c] == '>') {
                    fillGuardSightWithBlockers(mat, r, c, m, n, mat[r][c]);
                }
            }
        }
        System.out.println("here - 0");
        System.out.println(Arrays.deepToString(mat));
        for (int r = 0; r < m; ++r) {
            for (int c = 0; c < n; ++c) {
                if (mat[r][c] == 'A') {
                    return canReach(mat, r, c, m, n);
                }
            }
        }
        System.out.println("here");
        System.out.println(Arrays.deepToString(mat));
        return false;
    }

    public static void main(String[] args) {
        String[] s = {"...Xv", "AX..^", ".XX.."};
        System.out.println(new test().solution(s));
    }
}
