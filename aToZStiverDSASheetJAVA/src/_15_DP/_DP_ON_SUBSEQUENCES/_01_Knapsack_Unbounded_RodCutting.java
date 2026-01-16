package aToZStiverDSASheetJAVA.src._15_DP._DP_ON_SUBSEQUENCES;
//https://www.geeksforgeeks.org/problems/rod-cutting0840/1
public class _01_Knapsack_Unbounded_RodCutting {
    //Memoization
    class Solution {

        // dp[ind][n] = maximum profit using pieces from 0..ind
        // to cut a rod of length 'n'
        int[][] dp;

        public int solve(int[] price, int ind, int n) {

            // Base case:
            // Only piece of length 1 (ind == 0) is available.
            // We can cut the rod into 'n' pieces of length 1.
            if (ind == 0) {
                return n * price[0];
            }

            // If already computed, return cached value
            if (dp[ind][n] != -1) return dp[ind][n];

            // Option 1: Do not take the current piece length (ind+1)
            int notTake = solve(price, ind - 1, n);

            // Option 2: Take the current piece length (ind+1)
            // Since it's unbounded, we stay on the same index
            int take = Integer.MIN_VALUE;
            if (ind + 1 <= n) {
                take = price[ind] + solve(price, ind, n - (ind + 1));
            }

            // Store and return the maximum profit
            return dp[ind][n] = Math.max(take, notTake);
        }

        public int cutRod(int[] price) {
            int n = price.length;

            // dp table of size [n][n+1]
            dp = new int[n][n + 1];
            for (int i = 0; i < n; i++) {
                Arrays.fill(dp[i], -1);
            }

            // Start from the last index with full rod length
            return solve(price, n - 1, n);
        }
    }

    //Tabulation
    class Solution {
        public int cutRod(int[] price) {
            int n = price.length;

            // dp[i][len] = maximum profit using pieces of length
            // 1..(i+1) to cut a rod of total length 'len'
            int[][] dp = new int[n][n + 1];

        /*
            Base case: only piece of length 1 (i = 0) is available.
            For any rod length 'len', the best we can do is:
                len * price[0]
        */
            for (int len = 0; len <= n; len++) {
                dp[0][len] = len * price[0];
            }

            // Fill the DP table
            for (int i = 1; i < n; i++) {
                for (int len = 0; len <= n; len++) {

                    // Option 1: Do not take piece of length (i + 1)
                    int notTake = dp[i - 1][len];

                    // Option 2: Take piece of length (i + 1)
                    // Unbounded -> stay on the same row 'i'
                    int take = Integer.MIN_VALUE;
                    if (i + 1 <= len) {
                        take = price[i] + dp[i][len - (i + 1)];
                    }

                    // Store the best of both choices
                    dp[i][len] = Math.max(take, notTake);
                }
            }

            // Maximum profit for rod of length 'n'
            return dp[n - 1][n];
        }
    }


}
