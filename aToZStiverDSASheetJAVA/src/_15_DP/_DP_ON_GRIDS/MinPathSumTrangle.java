package aToZStiverDSASheetJAVA.src._15_DP._DP_ON_GRIDS;

public class MinPathSumTrangle {
    // Memoization - TC - O(n^2) | SC - O(n^2) + O(n)
    class Solution {

        // dp[i][j] stores the minimum path sum from (i, j) to the bottom
        int[][] dp;

        public int solve(List<List<Integer>> triangle, int i, int j) {

            // Base case: last row
            if (i == triangle.size() - 1) {
                return triangle.get(i).get(j);
            }

            // If already computed, return cached value
            if (dp[i][j] != -1) return dp[i][j];

            // Two choices: down and diagonal
            int down = solve(triangle, i + 1, j);
            int diag = solve(triangle, i + 1, j + 1);

            // Current value + minimum of both paths
            return dp[i][j] = triangle.get(i).get(j) + Math.min(down, diag);
        }

        public int minimumTotal(List<List<Integer>> triangle) {
            int n = triangle.size();

            dp = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(dp[i], -1);
            }

            // Start from the top of the triangle
            return solve(triangle, 0, 0);
        }
    }
//Tabulation - TC - O(n²) | SC - O(n²)
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int n = triangle.size();

            // dp[i][j] stores the minimum path sum from (i, j) to the bottom
            int[][] dp = new int[n][n];

            // Base case: copy the last row of the triangle
            for (int j = n - 1; j >= 0; j--) {
                dp[n - 1][j] = triangle.get(n - 1).get(j);
            }

            // Build the solution from bottom to top
            for (int i = n - 2; i >= 0; i--) {
                for (int j = i; j >= 0; j--) {
                    int down = dp[i + 1][j];
                    int diag = dp[i + 1][j + 1];

                    // Current value + minimum of the two possible paths
                    dp[i][j] = triangle.get(i).get(j) + Math.min(down, diag);
                }
            }

            // The answer ends up at the top
            return dp[0][0];
        }
    }


}
