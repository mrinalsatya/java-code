package aToZStiverDSASheetJAVA.src._15_DP._1D_DP;
//https://www.geeksforgeeks.org/problems/geek-jump/1
public class FrogJump {
    //memoization
    class Solution {
        int[] dp;
        public int solve(int[] height, int n){
            if(n==0){
                return 0;
            }
            if(dp[n] != -1){
                return dp[n];
            }
            int left = solve(height, n-1) + Math.abs(height[n] - height[n-1]);
            int right = Integer.MAX_VALUE;
            if(n > 1){
                right = solve(height, n-2) + Math.abs(height[n] - height[n-2]);
            }
            return dp[n] = Math.min(left,right);
        }
        int minCost(int[] height) {
            // code here
            dp = new int[height.length+1];
            Arrays.fill(dp,-1);
            return solve(height, height.length-1);
        }
    }
    //Tabulation
    class Solution {

        int minCost(int[] height) {
            // code here
            int n = height.length;
            int[] dp = new int[n+1];
            Arrays.fill(dp,-1);
            dp[0] = 0;
            for(int i = 1; i<n;i++){
                int one = dp[i-1] + Math.abs(height[i] - height[i-1]);
                int two = Integer.MAX_VALUE;
                if(i > 1){
                    two = dp[i-2] + Math.abs(height[i] - height[i-2]);
                }

                dp[i] = Math.min(one,two);
            }

            return dp[n-1];
        }
    }
}
