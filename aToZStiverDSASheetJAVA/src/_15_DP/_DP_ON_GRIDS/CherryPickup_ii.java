package aToZStiverDSASheetJAVA.src._15_DP._DP_ON_GRIDS;
//https://leetcode.com/problems/cherry-pickup-ii/
public class CherryPickup_ii {
    //memoization - TC - O(r * c * c * 9) → simplified to O(r * c²) | SC - O(r * c²) + O(r)
    class Solution {

        // dp[i][j1][j2] stores the maximum cherries that can be collected
        // starting from row i, when:
        //  - Robot 1 is at column j1
        //  - Robot 2 is at column j2
        int[][][] dp;

        public int solve(int i, int j1, int j2, int[][] grid, int r, int c) {

            // If either robot goes out of bounds or row exceeds grid
            // This path is invalid
            if (i >= r || j1 < 0 || j2 < 0 || j1 >= c || j2 >= c) {
                return Integer.MIN_VALUE;
            }

            // Base case: last row
            // If both robots are on the same cell, count it once
            if (i == r - 1) {
                if (j1 == j2) {
                    return grid[i][j1];
                } else {
                    return grid[i][j1] + grid[i][j2];
                }
            }

            // If already computed, return memoized result
            if (dp[i][j1][j2] != Integer.MIN_VALUE) {
                return dp[i][j1][j2];
            }

            int maxi = Integer.MIN_VALUE;

            // Try all 3x3 movement combinations for both robots
            // Each robot can move: left (-1), stay (0), right (+1)
            for (int dj1 = -1; dj1 <= 1; dj1++) {
                for (int dj2 = -1; dj2 <= 1; dj2++) {

                    int val;

                    // Collect cherries from current cells
                    if (j1 == j2) {
                        val = grid[i][j1];
                    } else {
                        val = grid[i][j1] + grid[i][j2];
                    }

                    // Add result of next row
                    val += solve(i + 1, j1 + dj1, j2 + dj2, grid, r, c);

                    // Take the best among all possibilities
                    maxi = Math.max(maxi, val);
                }
            }

            // Store and return the result
            return dp[i][j1][j2] = maxi;
        }

        public int cherryPickup(int[][] grid) {
            int m = grid.length, n = grid[0].length;

            // Initialize DP with sentinel value
            dp = new int[m][n][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    Arrays.fill(dp[i][j], Integer.MIN_VALUE);
                }
            }

            // Robot 1 starts at (0, 0), Robot 2 at (0, n-1)
            return solve(0, 0, n - 1, grid, m, n);
        }
    }

    //Tabulation  - TC - O(r * c * c * 9) → simplified to O(r * c²) | SC - O(r * c²)
    class Solution {

        public int cherryPickup(int[][] grid) {

            int r = grid.length;
            int c = grid[0].length;

            // dp[i][j1][j2] represents the maximum cherries that can be collected
            // starting from row i, when:
            //  - Robot 1 is at column j1
            //  - Robot 2 is at column j2
            int[][][] dp = new int[r][c][c];

            // Initialize all states with a very small value (acts like -infinity)
            // This helps in safely taking maximum later
            for (int[][] matrix : dp) {
                for (int[] row : matrix) {
                    Arrays.fill(row, Integer.MIN_VALUE);
                }
            }

            // Base case: last row
            // If both robots land on the same cell, count it once
            // Otherwise, count both cells
            for (int j1 = 0; j1 < c; j1++) {
                for (int j2 = 0; j2 < c; j2++) {
                    if (j1 == j2) {
                        dp[r - 1][j1][j2] = grid[r - 1][j1];
                    } else {
                        dp[r - 1][j1][j2] = grid[r - 1][j1] + grid[r - 1][j2];
                    }
                }
            }

            // Fill the DP table from bottom to top
            for (int i = r - 2; i >= 0; i--) {
                for (int j1 = 0; j1 < c; j1++) {      // Robot 1 column
                    for (int j2 = 0; j2 < c; j2++) {  // Robot 2 column

                        int maxCherries = Integer.MIN_VALUE;

                        // Each robot can move: left (-1), stay (0), right (+1)
                        // Try all 3 × 3 movement combinations
                        for (int dj1 = -1; dj1 <= 1; dj1++) {
                            for (int dj2 = -1; dj2 <= 1; dj2++) {

                                int newJ1 = j1 + dj1;
                                int newJ2 = j2 + dj2;

                                // Check if both robots remain inside the grid
                                if (newJ1 >= 0 && newJ1 < c && newJ2 >= 0 && newJ2 < c) {

                                    // Cherries collected at the current row
                                    int cherries;
                                    if (j1 == j2) {
                                        cherries = grid[i][j1];
                                    } else {
                                        cherries = grid[i][j1] + grid[i][j2];
                                    }

                                    // Add the best result from the next row
                                    cherries += dp[i + 1][newJ1][newJ2];

                                    // Update maximum
                                    maxCherries = Math.max(maxCherries, cherries);
                                }
                            }
                        }

                        // Store the best possible result for this state
                        dp[i][j1][j2] = maxCherries;
                    }
                }
            }

            // Robot 1 starts at column 0, Robot 2 at column c-1
            return dp[0][0][c - 1];
        }
    }


}
