package SEP.work1.MON;

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
