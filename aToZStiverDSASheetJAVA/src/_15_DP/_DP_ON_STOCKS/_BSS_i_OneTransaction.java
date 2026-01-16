package aToZStiverDSASheetJAVA.src._15_DP._DP_ON_STOCKS;
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
public class _BSS_i_OneTransaction {
    class Solution {
        public int maxProfit(int[] prices) {
            int minPrice = prices[0];   // best price to buy so far
            int maxProfit = 0;          // best profit so far

            for (int i = 1; i < prices.length; i++) {
                // If we sell today, what profit would we make?
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);

                // Update minimum price seen so far
                minPrice = Math.min(minPrice, prices[i]);
            }

            return maxProfit;
        }
    }

}
