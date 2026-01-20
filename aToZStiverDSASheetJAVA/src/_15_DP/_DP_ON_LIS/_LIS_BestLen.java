package aToZStiverDSASheetJAVA.src._15_DP._DP_ON_LIS;
// SC - O(n)
public class _LIS_BestLen {
    class Solution {
        public int lengthOfLIS(int[] nums) {
            int n = nums.length;

            // dp[i] = length of LIS that ends at index i
            int[] dp = new int[n];

            // Every single element is an LIS of length 1 by itself
            Arrays.fill(dp, 1);

            int max = 1; // stores the overall LIS length

            for (int ind = 0; ind < n; ind++) {
                for (int prevInd = 0; prevInd < ind; prevInd++) {

                    // If we can extend the subsequence ending at prevInd
                    if (nums[prevInd] < nums[ind]) {
                        dp[ind] = Math.max(dp[ind], 1 + dp[prevInd]);
                    }
                }

                // Update global maximum
                max = Math.max(max, dp[ind]);
            }

            return max;
        }
    }

}
