package aToZStiverDSASheetJAVA.src._07_Recursion.Backtracking;

//https://leetcode.com/problems/sudoku-solver/

/*
⏱️ Time Complexity
Worst-Case Time Complexity:
O(9^(number of empty cells))


Each empty cell can try 9 digits

In worst case, board is almost empty

This is exponential, but:

Constraints are fixed (9×9)

Practical runtime is acceptable

👉 In interviews, you can confidently say:

“Exponential in worst case, but bounded because the board size is fixed.”
 */
public class SudokuSolver {
    class Solution {

        // Recursive backtracking function to solve the Sudoku
        public boolean solve(char[][] board) {

            // Traverse the board cell by cell
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {

                    // If we find an empty cell
                    if (board[i][j] == '.') {

                        // Try placing digits '1' to '9'
                        for (char num = '1'; num <= '9'; num++) {

                            // Check if placing num here is valid
                            if (isValid(board, i, j, num)) {

                                // Place the number
                                board[i][j] = num;

                                // Recursively try to solve the rest of the board
                                if (solve(board)) {
                                    return true; // solution found
                                }

                                // Backtrack: undo the placement
                                board[i][j] = '.';
                            }
                        }

                        // If no number fits in this cell, return false
                        return false;
                    }
                }
            }

            // If no empty cells are left, Sudoku is solved
            return true;
        }

        // Function to check whether placing 'num' at board[i][j] is valid
        public boolean isValid(char[][] board, int i, int j, char num) {

            for (int ind = 0; ind < 9; ind++) {

                // Check the row
                if (board[i][ind] == num) return false;

                // Check the column
                if (board[ind][j] == num) return false;

                // Check the 3x3 subgrid
            /*
               Formula explanation:
               - (i/3)*3 gives starting row of subgrid
               - (j/3)*3 gives starting column of subgrid
               - ind/3 moves row inside subgrid
               - ind%3 moves column inside subgrid
            */
                if (board[3 * (i / 3) + (ind / 3)]
                        [3 * (j / 3) + (ind % 3)] == num)
                    return false;
            }

            return true; // placement is valid
        }

        // Main function called by LeetCode
        public void solveSudoku(char[][] board) {
            solve(board);
        }
    }

}
