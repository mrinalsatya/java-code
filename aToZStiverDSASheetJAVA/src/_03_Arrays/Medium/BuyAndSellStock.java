package aToZStiverDSASheetJAVA.src._03_Arrays.Medium;

public class BuyAndSellStock {
    class Solution {
        public int maxProfit(int[] prices) {
            int buyPrice = prices[0], sellPrice = prices[0], totalProfit = 0;
            for(int i = 1; i < prices.length; i++){
                if(prices[i] < buyPrice){
                    totalProfit = Math.max(totalProfit, sellPrice - buyPrice);
                    buyPrice = prices[i];
                    sellPrice = prices[i];
                }
                if(prices[i] > sellPrice){
                    sellPrice = prices[i];
                }
            }

            totalProfit = Math.max(totalProfit, sellPrice - buyPrice);

            return totalProfit;

        }
    }
}
