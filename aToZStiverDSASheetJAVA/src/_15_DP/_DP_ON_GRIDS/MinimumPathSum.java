package aToZStiverDSASheetJAVA.src._15_DP._DP_ON_GRIDS;
//https://leetcode.com/problems/minimum-path-sum/
public class MinimumPathSum {
    //Memorization - TC - O(m*n) | SC - O(m*n) + O(m+n)
    class Solution {

        int[][] dp;  // dp[i][j] stores minimum path sum to reach cell (i, j)

        public int solve(int[][] grid, int m, int n) {

            // Base case: starting cell
            if (m == 0 && n == 0) {
                return grid[0][0];
            }

            // Out of bounds → invalid path, return large value
            if (m < 0 || n < 0) return Integer.MAX_VALUE;

            // Return cached result
            if (dp[m][n] != -1) return dp[m][n];

            // Minimum of coming from top or left
            int up = solve(grid, m - 1, n);
            int left = solve(grid, m, n - 1);

            // Store and return result
            return dp[m][n] = grid[m][n] + Math.min(up, left);
        }

        public int minPathSum(int[][] grid) {
            int m = grid.length, n = grid[0].length;

            dp = new int[m][n];
            for (int i = 0; i < m; i++) {
                Arrays.fill(dp[i], -1);
            }

            // Compute minimum path sum to bottom-right cell
            return solve(grid, m - 1, n - 1);
        }
    }
//Tabulation - TC - O(m*n) | SC - O(m*n)
    class Solution {

        public int minPathSum(int[][] grid) {

            int m = grid.length, n = grid[0].length;

            // dp[i][j] stores the minimum path sum to reach cell (i, j)
            int[][] dp = new int[m][n];

            // Base case: starting cell
            dp[0][0] = grid[0][0];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {

                    // Skip the starting cell (already initialized)
                    if (i == 0 && j == 0) continue;

                    int up = Integer.MAX_VALUE;
                    int left = Integer.MAX_VALUE;

                    // Value from the top cell
                    if (i > 0) up = dp[i - 1][j];

                    // Value from the left cell
                    if (j > 0) left = dp[i][j - 1];

                    // Current cell cost + minimum of two paths
                    dp[i][j] = grid[i][j] + Math.min(up, left);
                }
            }

            // Minimum cost to reach bottom-right cell
            return dp[m - 1][n - 1];
        }
    }


}
