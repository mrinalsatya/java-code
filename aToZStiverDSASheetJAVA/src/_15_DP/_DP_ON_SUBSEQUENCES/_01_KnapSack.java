package aToZStiverDSASheetJAVA.src._15_DP._DP_ON_SUBSEQUENCES;
//https://www.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1
public class _01_KnapSack {
    //Memoization
    class Solution {

        // dp[i][w] stores the maximum value that can be achieved
        // using items from index 0 to i with remaining capacity w
        int[][] dp;

        public int solve(int w, int val[], int wt[], int ind) {

            // Base case: only one item (index 0) is available
            if (ind == 0) {
                // If it fits, take it; otherwise, take nothing
                if (wt[0] <= w) {
                    return val[0];
                }
                return 0;
            }

            // If already computed, return cached result
            if (dp[ind][w] != -1) return dp[ind][w];

            // Option 1: Do not take current item
            int notTake = solve(w, val, wt, ind - 1);

            // Option 2: Take current item (if it fits)
            int take = Integer.MIN_VALUE;
            if (wt[ind] <= w) {
                take = val[ind] + solve(w - wt[ind], val, wt, ind - 1);
            }

            // Store and return the best of both choices
            return dp[ind][w] = Math.max(notTake, take);
        }

        public int knapsack(int W, int val[], int wt[]) {
            int n = val.length;

            // Initialize DP table with -1 (uncomputed)
            dp = new int[n][W + 1];
            for (int i = 0; i < n; i++) {
                Arrays.fill(dp[i], -1);
            }

            // Start from the last index with full capacity
            return solve(W, val, wt, n - 1);
        }
    }
//Tabulation

    class Solution {

        public int knapsack(int W, int val[], int wt[]) {
            int n = val.length;

            // dp[i][w] = maximum value that can be obtained
            // using items from index 0 to i with capacity w
            int[][] dp = new int[n][W + 1];

            // Base case: only item 0 is available
            for (int w = 0; w <= W; w++) {
                if (wt[0] <= w) {
                    dp[0][w] = val[0];
                }
            }

            // Fill the DP table
            for (int i = 1; i < n; i++) {
                for (int w = 0; w <= W; w++) {

                    // Option 1: Do not take current item
                    int notTake = dp[i - 1][w];

                    // Option 2: Take current item (if it fits)
                    int take = Integer.MIN_VALUE;
                    if (wt[i] <= w) {
                        take = val[i] + dp[i - 1][w - wt[i]];
                    }

                    // Choose the better of the two
                    dp[i][w] = Math.max(take, notTake);
                }
            }

            // Answer: best value using all items and full capacity
            return dp[n - 1][W];
        }
    }

}
