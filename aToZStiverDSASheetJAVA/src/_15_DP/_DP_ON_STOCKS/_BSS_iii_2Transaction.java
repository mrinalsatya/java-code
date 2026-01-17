package aToZStiverDSASheetJAVA.src._15_DP._DP_ON_STOCKS;
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
public class _BSS_iii_2Transaction {

    //Memoization
    class Solution {

        // dp[ind][buy][cap] = maximum profit we can make starting from:
        // ind  -> current day
        // buy  -> 1 if we are allowed to buy, 0 if we are holding a stock
        // cap  -> number of transactions left
        int[][][] dp;

        public int solve(int[] prices, int ind, int buy, int cap) {

            // Base case:
            // If no days left OR no transactions left
            if (ind == prices.length || cap == 0) return 0;

            // If already computed, return cached value
            if (dp[ind][buy][cap] != -1) return dp[ind][buy][cap];

            // If we are allowed to buy
            if (buy == 1) {
                // Two choices:
                // 1) Buy today  -> -prices[ind] + solve(ind+1, 0, cap)
                // 2) Skip today -> solve(ind+1, 1, cap)
                return dp[ind][buy][cap] = Math.max(
                        -prices[ind] + solve(prices, ind + 1, 0, cap),
                        solve(prices, ind + 1, 1, cap)
                );
            }

            // We are holding a stock (must sell or skip)
            // Two choices:
            // 1) Sell today -> prices[ind] + solve(ind+1, 1, cap-1)
            // 2) Skip       -> solve(ind+1, 0, cap)
            return dp[ind][buy][cap] = Math.max(
                    prices[ind] + solve(prices, ind + 1, 1, cap - 1),
                    solve(prices, ind + 1, 0, cap)
            );
        }

        public int maxProfit(int[] prices) {
            int n = prices.length;

            // dp dimensions: [n][2][3]
            // cap ranges from 0..2
            dp = new int[n][2][3];

            // Initialize with -1 (uncomputed)
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 2; j++) {
                    Arrays.fill(dp[i][j], -1);
                }
            }

            // Start from day 0, allowed to buy, with 2 transactions
            return solve(prices, 0, 1, 2);
        }
    }
    //Tabulation
    class Solution {

        public int maxProfit(int[] prices) {
            int n = prices.length;

            // dp[i][buy][cap] = maximum profit starting from day i
            // buy = 1 -> we are allowed to buy
            // buy = 0 -> we are holding a stock and can sell
            // cap = number of transactions left (0, 1, or 2)
            int[][][] dp = new int[n + 1][2][3];

            // Base case:
            // dp[n][*][*] = 0  -> no days left, no profit possible
            // dp[*][*][0] = 0  -> no transactions left, no profit possible
            // (Arrays are already initialized to 0)

            // Fill the table from back to front
            for (int i = n - 1; i >= 0; i--) {
                for (int buy = 0; buy < 2; buy++) {
                    for (int cap = 1; cap < 3; cap++) {

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

            // Start from day 0, allowed to buy, with 2 transactions
            return dp[0][1][2];
        }
    }

}
