package aToZStiverDSASheetJAVA.src._15_DP._1D_DP;
//https://leetcode.com/problems/house-robber/description/
public class MaxSubsequenceSum {
    //memorization
    class Solution {
        int[] dp;
        public int solve(int[] nums, int n){
            if(n==0){
                return nums[0];
            }

            if(n < 0) return 0;
            if(dp[n] != -1) return dp[n];
            int one = nums[n] + solve(nums, n-2);
            int two = solve(nums, n-1);

            return dp[n] = Math.max(one,two);
        }
        public int rob(int[] nums) {
            dp = new int[nums.length];
            Arrays.fill(dp,-1);
            return solve(nums, nums.length-1);
        }
    }

    //tabulation
    class Solution {
        public int rob(int[] nums) {
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            for(int i=1; i<nums.length; i++){
                int take = nums[i];
                if(i > 1) take += dp[i-2];
                int notTake = dp[i-1];
                dp[i] = Math.max(take,notTake);
            }

            return dp[nums.length-1];
        }
    }
    //without extra space
    class Solution {
        public int rob(int[] nums) {
            int prev = nums[0];
            int prev2 = 0;
            for(int i=1; i<nums.length; i++){
                int take = nums[i];
                if(i > 1) take += prev2;
                int notTake = prev;
                int curr = Math.max(take,notTake);
                prev2 = prev;
                prev = curr;
            }

            return prev;
        }
    }
}
