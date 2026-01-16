package aToZStiverDSASheetJAVA.src._15_DP._DP_ON_SUBSEQUENCES;
//https://leetcode.com/problems/coin-change-ii/description/
public class _01_Knapsack_CoinChange_ii {
    //Memoization
    class Solution {

        public int solve(int[] coins, int ind, int k) {

            // Base case: only coin[0] is available
            if (ind == 0) {
                // If k can be formed using only coins[0], it's 1 valid way
                if (k % coins[0] == 0) return 1;
                return 0;
            }

            // Option 1: Do not take current coin
            int notTake = solve(coins, ind - 1, k);

            // Option 2: Take current coin (unbounded, so stay at same index)
            int take = 0;
            if (coins[ind] <= k) {
                take = solve(coins, ind, k - coins[ind]);
            }

            // Total ways
            return take + notTake;
        }

        public int change(int amount, int[] coins) {
            int n = coins.length;
            // Start from the last index
            return solve(coins, n - 1, amount);
        }
    }

    //Tabulation
    class Solution {

        public int change(int amount, int[] coins) {
            int n = coins.length;

            // dp[i][j] = number of ways to make sum 'j'
            // using coins from index 0 to i (unbounded)
            int[][] dp = new int[n][amount + 1];

            // Base case: using only coins[0]
            // We can form j if j is divisible by coins[0]
            for (int j = 0; j <= amount; j++) {
                if (j % coins[0] == 0) {
                    dp[0][j] = 1;
                }
            }

            // Fill the DP table
            for (int i = 1; i < n; i++) {
                for (int j = 0; j <= amount; j++) {

                    // Option 1: Do not take current coin
                    int notTake = dp[i - 1][j];

                    // Option 2: Take current coin (unbounded, so stay on same row)
                    int take = 0;
                    if (coins[i] <= j) {
                        take = dp[i][j - coins[i]];
                    }

                    dp[i][j] = take + notTake;
                }
            }

            // Number of combinations to make 'amount'
            return dp[n - 1][amount];
        }
    }

}
