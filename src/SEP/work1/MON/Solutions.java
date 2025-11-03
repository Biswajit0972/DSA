package SEP.work1.MON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solutions {
    public static boolean exist(char[][] board, String word) {
        int rows = board.length, cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (existHelper(board, i, j, 0, word.length(), visited, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean existHelper(char[][] grid, int i, int j, int strIdx, int strLen, boolean[][] visited, String word) {
        if (strIdx == strLen) {
            return true;
        }

        //! check the boundary conditions
//        if (i == 0 && j == 0 || i == grid.length - 1 && j == grid[0].length - 1 && visited[i][j] || grid[i][j] != word.charAt(strIdx)) {
//            return false;
//        }
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] != word.charAt(strIdx)) {
            return false;
        }

        visited[i][j] = true;
        // right || left || up || down
        boolean canIGetAnswer = existHelper(grid, i, j + 1, strIdx + 1, strLen, visited, word) ||
                existHelper(grid, i, j - 1, strIdx + 1, strLen, visited, word) ||
                existHelper(grid, i + 1, j, strIdx + 1, strLen, visited, word) ||
                existHelper(grid, i - 1, j, strIdx + 1, strLen, visited, word);

        visited[i][j] = false;
        return canIGetAnswer;
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];

        // Initialize board with '.'
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        // Columns, diagonal1, diagonal2 sets to track attacks
        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n];
        boolean[] diag2 = new boolean[2 * n];

        backtrack(0, n, board, ans, cols, diag1, diag2);
        return ans;
    }

    private void backtrack(int row, int n, char[][] board, List<List<String>> ans,
                           boolean[] cols, boolean[] diag1, boolean[] diag2) {

        // Base case: all queens are placed
        if (row == n) {
            List<String> curr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                curr.add(new String(board[i]));
            }
            ans.add(curr);
            return;
        }

        // Try placing queen in each column of this row
        for (int col = 0; col < n; col++) {
            int d1 = row - col + n; // diagonal1 index
            int d2 = row + col;     // diagonal2 index

            // If safe position
            if (!cols[col] && !diag1[d1] && !diag2[d2]) {
                board[row][col] = 'Q';
                cols[col] = diag1[d1] = diag2[d2] = true;

                backtrack(row + 1, n, board, ans, cols, diag1, diag2);

                // Backtrack
                board[row][col] = '.';
                cols[col] = diag1[d1] = diag2[d2] = false;
            }
        }
    }



    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        System.out.println(exist(board, word));
    }
}
