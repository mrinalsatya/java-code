package aToZStiverDSASheetJAVA.src._07_Recursion.Backtracking;
//https://leetcode.com/problems/n-queens/

// This is the optimal N-Queens solution using backtracking with O(1) row and diagonal checks, achieving O(N!) time and O(N) auxiliary space
public class NQueens {
    class Solution {

        // This will store all valid board configurations
        List<List<String>> ans = new ArrayList<>();

        /**
         * Recursive function to place queens column by column
         *
         * @param col            current column where we want to place a queen
         * @param board          chessboard representation
         * @param leftRow        tracks if a queen is already placed in a row
         * @param upperDiagonal  tracks upper diagonals (↗)
         * @param lowerDiagonal  tracks lower diagonals (↘)
         */
        public void solve(int col, char[][] board,
                          int[] leftRow,
                          int[] upperDiagonal,
                          int[] lowerDiagonal) {

            int n = board.length;

            // Base case: all columns filled => valid configuration found
            if (col == n) {
                ans.add(construct(board));
                return;
            }

            // Try placing a queen in every row of the current column
            for (int row = 0; row < n; row++) {

                // Check if placing queen at (row, col) is safe
                if (leftRow[row] == 0 &&
                        lowerDiagonal[row + col] == 0 &&
                        upperDiagonal[n - 1 + col - row] == 0) {

                    // Place the queen
                    board[row][col] = 'Q';
                    leftRow[row] = 1;
                    lowerDiagonal[row + col] = 1;
                    upperDiagonal[n - 1 + col - row] = 1;

                    // Move to next column
                    solve(col + 1, board, leftRow, upperDiagonal, lowerDiagonal);

                    // Backtrack: remove queen and reset markers
                    board[row][col] = '.';
                    leftRow[row] = 0;
                    lowerDiagonal[row + col] = 0;
                    upperDiagonal[n - 1 + col - row] = 0;
                }
            }
        }

        /**
         * Converts the board into List<String> format
         * required by the problem
         */
        public List<String> construct(char[][] board) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                temp.add(new String(board[i]));
            }
            return temp;
        }

        /**
         * Main function to initialize board and helper arrays
         */
        public List<List<String>> solveNQueens(int n) {

            // Initialize empty board
            char[][] board = new char[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(board[i], '.');
            }

            // Helper arrays to track attacks
            int[] leftRow = new int[n];          // rows
            int[] upperDiagonal = new int[2*n-1]; // ↗ diagonals
            int[] lowerDiagonal = new int[2*n-1]; // ↘ diagonals

            // Start solving from column 0
            solve(0, board, leftRow, upperDiagonal, lowerDiagonal);

            return ans;
        }
    }
}
