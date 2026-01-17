package aToZStiverDSASheetJAVA.src._15_DP._DP_ON_STOCKS;
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
public class _BSS_iv_kTransaction {
    class Solution {
        public int maxProfit(int k, int[] prices) {
            int n = prices.length;

            // dp[i][buy][cap] = maximum profit starting from day i
            // buy = 1 -> we are allowed to buy
            // buy = 0 -> we are holding a stock and can sell
            // cap = number of transactions left (1..k)
            int[][][] dp = new int[n + 1][2][k + 1];

            // Base cases are already 0:
            // dp[n][*][*] = 0  -> no days left
            // dp[*][*][0] = 0  -> no transactions left

            // Fill the table from back to front
            for (int i = n - 1; i >= 0; i--) {
                for (int buy = 0; buy < 2; buy++) {
                    for (int cap = 1; cap <= k; cap++) {

                        if (buy == 1) {
                            // We are allowed to buy:
                            // 1) Buy today  -> -prices[i] + dp[i+1][0][cap]
                            // 2) Skip today -> dp[i+1][1][cap]
                            dp[i][buy][cap] = Math.max(
                                    -prices[i] + dp[i + 1][0][cap],
                                    dp[i + 1][1][cap]
                            );
                        } else {
                            // We are holding a stock:
                            // 1) Sell today -> prices[i] + dp[i+1][1][cap-1]
                            // 2) Skip       -> dp[i+1][0][cap]
                            dp[i][buy][cap] = Math.max(
                                    prices[i] + dp[i + 1][1][cap - 1],
                                    dp[i + 1][0][cap]
                            );
                        }
                    }
                }
            }

            // Start from day 0, allowed to buy, with k transactions
            return dp[0][1][k];
        }
    }

}
