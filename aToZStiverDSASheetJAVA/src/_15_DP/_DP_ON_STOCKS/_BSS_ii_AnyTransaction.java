package aToZStiverDSASheetJAVA.src._15_DP._DP_ON_STOCKS;
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
public class _BSS_ii_AnyTransaction {
    //memoization
    class Solution {

        // dp[ind][buy] = maximum profit we can make starting from day 'ind'
        // 'buy' = 1  -> we are allowed to buy
        // 'buy' = 0  -> we are holding a stock and can sell
        int[][] dp;

        public int solve(int[] prices, int ind, int buy) {

            // Base case: no days left
            if (ind == prices.length) return 0;

            // If already computed, return cached value
            if (dp[ind][buy] != -1) return dp[ind][buy];

            int profit;

            if (buy == 1) {
                // We have two choices:
                // 1) Buy the stock today  -> -prices[ind] + solve(ind+1, 0)
                // 2) Skip today           -> solve(ind+1, 1)
                profit = Math.max(
                        -prices[ind] + solve(prices, ind + 1, 0),
                        solve(prices, ind + 1, 1)
                );
            } else {
                // We are holding a stock, two choices:
                // 1) Sell today -> prices[ind] + solve(ind+1, 1)
                // 2) Skip       -> solve(ind+1, 0)
                profit = Math.max(
                        prices[ind] + solve(prices, ind + 1, 1),
                        solve(prices, ind + 1, 0)
                );
            }

            return dp[ind][buy] = profit;
        }

        public int maxProfit(int[] prices) {
            int n = prices.length;

            // dp table initialized with -1 (uncomputed)
            dp = new int[n][2];
            for (int i = 0; i < n; i++) {
                Arrays.fill(dp[i], -1);
            }

            // Start from day 0 with the option to buy
            return solve(prices, 0, 1);
        }
    }
    //Tabulation
    class Solution {

        public int maxProfit(int[] prices) {
            int n = prices.length;

            // dp[i][buy] = maximum profit from day i onward
            // buy = 1 -> we are allowed to buy
            // buy = 0 -> we are holding a stock and can sell
            int[][] dp = new int[n + 1][2];

            // Base case:
            // On day n (beyond last day), profit is 0 regardless of state
            dp[n][0] = dp[n][1] = 0;

            // Fill the table from back to front
            for (int i = n - 1; i >= 0; i--) {
                for (int buy = 0; buy < 2; buy++) {

                    int profit;

                    if (buy == 1) {
                        // Two choices:
                        // 1) Buy today  -> -prices[i] + dp[i+1][0]
                        // 2) Skip today -> dp[i+1][1]
                        profit = Math.max(
                                -prices[i] + dp[i + 1][0],
                                dp[i + 1][1]
                        );
                    } else {
                        // We are holding a stock
                        // Two choices:
                        // 1) Sell today -> prices[i] + dp[i+1][1]
                        // 2) Skip       -> dp[i+1][0]
                        profit = Math.max(
                                prices[i] + dp[i + 1][1],
                                dp[i + 1][0]
                        );
                    }

                    dp[i][buy] = profit;
                }
            }

            // Start from day 0 with the option to buy
            return dp[0][1];
        }
    }

}
