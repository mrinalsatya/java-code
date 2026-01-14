package aToZStiverDSASheetJAVA.src._15_DP._DP_ON_GRIDS;
//https://leetcode.com/problems/minimum-falling-path-sum/description/
public class MinimumFailingPathSum {
    //memoization
    //Time Complexity: O(n²) | Space Complexity: O(n²)
    class Solution {
        int[][] dp;

        public int solve(int[][] matrix, int row, int col) {

            // Base case: first row, valid column
            if (row == 0 && col >= 0 && col < matrix.length) {
                return matrix[row][col];
            }

            // Out of bounds → invalid path
            if (row < 0 || col < 0 || col >= matrix.length) {
                return Integer.MAX_VALUE;
            }

            // If already computed, return cached value
            if (dp[row][col] != Integer.MAX_VALUE) return dp[row][col];

            int up = solve(matrix, row - 1, col);
            int leftDiag = solve(matrix, row - 1, col - 1);
            int rightDiag = solve(matrix, row - 1, col + 1);

            // Current value + minimum of three possible moves
            return dp[row][col] =
                    matrix[row][col] + Math.min(up, Math.min(leftDiag, rightDiag));
        }

        public int minFallingPathSum(int[][] matrix) {
            int n = matrix.length;
            dp = new int[n][n];

            // Initialize DP with sentinel value
            for (int i = 0; i < n; i++) {
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            }

            int mini = Integer.MAX_VALUE;

            // Try all columns in the last row as ending points
            for (int col = 0; col < n; col++) {
                mini = Math.min(mini, solve(matrix, n - 1, col));
            }

            return mini;
        }
    }
//Tabulation
    class Solution {
        public int minFallingPathSum(int[][] matrix) {
            int n = matrix.length;

            // dp[i][j] stores the minimum falling path sum to reach cell (i, j)
            int[][] dp = new int[n][n];

            // Base case: first row is same as matrix
            for (int j = 0; j < n; j++) {
                dp[0][j] = matrix[0][j];
            }

            // Build DP table row by row
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    int up = matrix[i][j] + dp[i - 1][j];

                    int leftDiag = Integer.MAX_VALUE;
                    if (j > 0) {
                        leftDiag = matrix[i][j] + dp[i - 1][j - 1];
                    }

                    int rightDiag = Integer.MAX_VALUE;
                    if (j < n - 1) {
                        rightDiag = matrix[i][j] + dp[i - 1][j + 1];
                    }

                    dp[i][j] = Math.min(up, Math.min(leftDiag, rightDiag));
                }
            }

            // Answer is the minimum value in the last row
            int mini = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                mini = Math.min(mini, dp[n - 1][j]);
            }

            return mini;
        }
    }


}
