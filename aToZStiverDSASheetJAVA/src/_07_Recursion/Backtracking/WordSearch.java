package aToZStiverDSASheetJAVA.src._07_Recursion.Backtracking;
//https://leetcode.com/problems/word-search/
/*
⏱️ Time Complexity

Let:

m = number of rows

n = number of columns

L = length of the word

Worst Case
𝑂(𝑚×𝑛×4^𝐿)
Explanation:

DFS starts from every cell → m × n

From each cell, up to 4 directions are explored

Maximum recursion depth = length of word (L)

➡️ Total possibilities = m × n × 4^L

This exponential complexity is unavoidable because all valid paths must be explored.

💾 Space Complexity
Auxiliary Space - O(L)
 */
public class WordSearch {
    class Solution {

        /**
         * helper() performs DFS to check whether the word can be formed
         * starting from cell (i, j) at index 'ind' of the word.
         */
        public boolean helper(char[][] board, int i, int j, String word, int ind) {

            // ✅ Base case: all characters of the word are matched
            if (ind == word.length()) {
                return true;
            }

            // ❌ Invalid cases:
            // 1. Out of grid bounds
            // 2. Current cell character does not match word[ind]
            if (i < 0 || i >= board.length ||
                    j < 0 || j >= board[0].length ||
                    board[i][j] != word.charAt(ind)) {
                return false;
            }

            // 🔒 Mark current cell as visited by modifying it temporarily
            char temp = board[i][j];
            board[i][j] = '.';

            // 🔍 Explore all 4 possible directions
            boolean found =
                    helper(board, i + 1, j, word, ind + 1) || // Down
                            helper(board, i, j + 1, word, ind + 1) || // Right
                            helper(board, i - 1, j, word, ind + 1) || // Up
                            helper(board, i, j - 1, word, ind + 1);   // Left

            // 🔓 Restore the original character (backtracking)
            board[i][j] = temp;

            return found;
        }

        /**
         * exist() checks if the given word exists in the board
         */
        public boolean exist(char[][] board, String word) {

            // Try starting DFS from every cell
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {

                    // Start searching the word from index 0
                    if (helper(board, i, j, word, 0)) {
                        return true;
                    }
                }
            }

            // Word not found anywhere in the board
            return false;
        }
    }

}
