package aToZStiverDSASheetJAVA.src._15_DP._DP_ON_STOCKS;
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
public class _BSS_vi_Fee {
    class Solution {
        public int maxProfit(int[] prices, int fee) {
            int n = prices.length;

            // dp[i][buy] = maximum profit starting from day i
            // buy = 1 -> we are allowed to buy
            // buy = 0 -> we are holding a stock and can sell
            int[][] dp = new int[n + 1][2];

            // Base case:
            // On day n (beyond last day), profit is 0
            dp[n][0] = dp[n][1] = 0;

            // Fill the DP table from back to front
            for (int i = n - 1; i >= 0; i--) {
                for (int buy = 0; buy < 2; buy++) {

                    int profit;

                    if (buy == 1) {
                        // We can buy:
                        // 1) Buy today  -> -prices[i] - fee + dp[i+1][0]
                        // 2) Skip today -> dp[i+1][1]
                        profit = Math.max(
                                -prices[i] + dp[i + 1][0] - fee,
                                dp[i + 1][1]
                        );
                    } else {
                        // We are holding a stock:
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
