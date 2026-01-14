package aToZStiverDSASheetJAVA.src._15_DP._DP_ON_SUBSEQUENCES;
//https://leetcode.com/problems/coin-change/
public class _01_Knapsack_CoinChange {
    class Solution {

        // dp[ind][k] = minimum coins needed to make sum k
        // using coins from index 0 to ind
        int[][] dp;

        public int solve(int[] coins, int k, int ind) {

            // If target becomes 0, no coins are needed
            if (k == 0) return 0;

            // Base case: only coin[0] is available
            if (ind == 0) {
                if (k % coins[0] == 0) return k / coins[0];
                return (int) 1e9; // impossible
            }

            // If already computed, return cached result
            if (dp[ind][k] != -1) return dp[ind][k];

            // Option 1: Do not take current coin
            int notTake = solve(coins, k, ind - 1);

            // Option 2: Take current coin (unbounded, so stay on same index)
            int take = (int) 1e9;
            if (coins[ind] <= k) {
                take = 1 + solve(coins, k - coins[ind], ind);
            }

            // Store and return minimum of both choices
            return dp[ind][k] = Math.min(take, notTake);
        }

        public int coinChange(int[] coins, int amount) {
            int n = coins.length;

            dp = new int[n][amount + 1];
            for (int i = 0; i < n; i++) {
                Arrays.fill(dp[i], -1);
            }

            int ans = solve(coins, amount, n - 1);

            // If not possible, return -1
            return ans >= (int) 1e9 ? -1 : ans;
        }
    }
    //Tabulation
    class Solution {

        public int coinChange(int[] coins, int amount) {
            int n = coins.length;

            // dp[i][j] = minimum number of coins needed to make sum 'j'
            // using coins from index 0 to i (unbounded usage)
            int[][] dp = new int[n][amount + 1];

            // ----- Base case: only coin[0] is available -----
            for (int j = 0; j <= amount; j++) {
                if (j % coins[0] == 0) {
                    dp[0][j] = j / coins[0];   // we can form j using coin[0]
                } else {
                    dp[0][j] = (int) 1e9;      // impossible
                }
            }

            // ----- Fill the DP table -----
            for (int i = 1; i < n; i++) {
                for (int j = 0; j <= amount; j++) {

                    // Option 1: Do not take current coin
                    int notTake = dp[i - 1][j];

                    // Option 2: Take current coin (unbounded, so stay on same row)
                    int take = (int) 1e9;
                    if (coins[i] <= j) {
                        take = 1 + dp[i][j - coins[i]];
                    }

                    // Choose the minimum of both
                    dp[i][j] = Math.min(take, notTake);
                }
            }

            // If result is still "infinity", it means impossible
            return dp[n - 1][amount] == (int) 1e9 ? -1 : dp[n - 1][amount];
        }
    }

}
