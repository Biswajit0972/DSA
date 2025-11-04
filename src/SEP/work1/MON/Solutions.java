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


    static String[] keypad = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return ans;
        }

        combinationBacktracking(digits, 0, ans, new StringBuilder());
        return ans;
    }

    private void combinationBacktracking(String digits, int idx, List<String> ans, StringBuilder sb) {

        //* step: Base case

        if (idx == digits.length()) {
            ans.add(sb.toString());
            return;
        }

        String digit = keypad[digits.charAt(idx) - '0'];

        for (int i = 0; i < digit.length(); i++) {
            sb.append(digit.charAt(i));
            combinationBacktracking(digits, idx + 1, ans, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        combinationSumHelper(candidates, target, 0, ans, new ArrayList<>(), 0);
        return ans;
    }

    private static void combinationSumHelper(int[] candidates, int target, int index, List<List<Integer>> res, List<Integer> curr, int sum) {
        // * base case 1
        if (index == candidates.length) return;
        // * base case 2
        if (sum == target) {
            res.add(new ArrayList<>(curr));
            return;
        }
        //* base case 3
        if (sum > target)  return;

        curr.add(candidates[index]);
        combinationSumHelper(candidates, target, index, res, curr, sum + candidates[index]);
        curr.removeLast();
        combinationSumHelper(candidates, target, index, res, curr, sum );
    }

    public static void main(String[] args) {
        for (List<Integer> s: combinationSum(new int[] {2,3,6,7,1}, 8)) {
            System.out.print("[ ");
            for (Integer num : s) {
                System.out.print(num + " ");
            }
            System.out.print(" ]");
        }
    }
}
