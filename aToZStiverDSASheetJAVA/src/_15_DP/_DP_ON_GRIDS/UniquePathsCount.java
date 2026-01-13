package aToZStiverDSASheetJAVA.src._15_DP._DP_ON_GRIDS;
//https://leetcode.com/problems/unique-paths/
public class UniquePathsCount {
    //memorization - TC - O(n*m) | SC - O(m*n) (dp table) + O(m+n) (recursion stack)
    class Solution {

        int[][] dp;  // dp[i][j] stores number of unique paths to cell (i, j)

        // Returns number of paths to reach cell (m, n)
        public int solve(int m, int n) {

            // Out of grid → no path
            if (m < 0 || n < 0) return 0;

            // Starting cell → one valid path
            if (m == 0 && n == 0) return 1;

            // If already computed, return cached result
            if (dp[m][n] != -1) return dp[m][n];

            // Paths from top + paths from left
            return dp[m][n] = solve(m - 1, n) + solve(m, n - 1);
        }

        public int uniquePaths(int m, int n) {
            dp = new int[m][n];

            // Initialize memo table with -1
            for (int i = 0; i < m; i++) {
                Arrays.fill(dp[i], -1);
            }

            // We compute paths to cell (m-1, n-1)
            return solve(m - 1, n - 1);
        }
    }

    //Tabulation - TC - O(m*n) | SC - O(m*n)

    class Solution {

        public int uniquePaths(int m, int n) {

            // dp[i][j] stores number of unique paths to reach cell (i, j)
            int[][] dp = new int[m][n];

            // Starting position
            dp[0][0] = 1;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {

                    // Skip the starting cell (already initialized)
                    if (i == 0 && j == 0) continue;

                    // Paths from the cell above
                    int up = (i > 0) ? dp[i - 1][j] : 0;

                    // Paths from the cell to the left
                    int left = (j > 0) ? dp[i][j - 1] : 0;

                    // Total paths to current cell
                    dp[i][j] = up + left;
                }
            }

            // Destination cell
            return dp[m - 1][n - 1];
        }
    }


}
