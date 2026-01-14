package aToZStiverDSASheetJAVA.src._15_DP._DP_ON_GRIDS;
//https://leetcode.com/problems/unique-paths-ii/
public class UniquePathsCountWithObstacles {
    //memoization - Tc - O(n*m) | SC - O(m*n) + O(m+n)
    class Solution {

        int[][] dp;  // dp[i][j] stores number of paths to reach cell (i, j)

        public int solve(int[][] obstacleGrid, int m, int n) {

            // If start cell is reached and it's not blocked → one valid path
            if (m == 0 && n == 0 && obstacleGrid[m][n] == 0) {
                return 1;
            }

            // Out of bounds or obstacle → no path
            if (m < 0 || n < 0 || obstacleGrid[m][n] == 1) return 0;

            // Return cached value if already computed
            if (dp[m][n] != -1) return dp[m][n];

            // Paths from top and left
            int up = solve(obstacleGrid, m - 1, n);
            int left = solve(obstacleGrid, m, n - 1);

            // Store and return result
            return dp[m][n] = up + left;
        }

        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length, n = obstacleGrid[0].length;

            dp = new int[m][n];
            for (int i = 0; i < m; i++) {
                Arrays.fill(dp[i], -1);
            }

            // Compute paths to bottom-right cell
            return solve(obstacleGrid, m - 1, n - 1);
        }
    }

    //Tabulation  - TC - O(n*m) | SC - O(n*m)

    class Solution {

        public int uniquePathsWithObstacles(int[][] obstacleGrid) {

            // If the starting cell itself is blocked, no path exists
            if (obstacleGrid[0][0] == 1) return 0;

            int m = obstacleGrid.length, n = obstacleGrid[0].length;

            // dp[i][j] = number of ways to reach cell (i, j)
            int[][] dp = new int[m][n];

            // Starting position
            dp[0][0] = 1;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {

                    // Skip the starting cell
                    if (i == 0 && j == 0) continue;

                    int up = 0, left = 0;

                    // If current cell is not an obstacle,
                    // it can receive paths from top and left
                    if (obstacleGrid[i][j] != 1) {
                        if (i > 0) up = dp[i - 1][j];
                        if (j > 0) left = dp[i][j - 1];
                    }

                    dp[i][j] = up + left;
                }
            }

            // Destination cell
            return dp[m - 1][n - 1];
        }
    }


}
