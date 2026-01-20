package aToZStiverDSASheetJAVA.src._15_DP._DP_ON_LIS;
//https://leetcode.com/problems/longest-increasing-subsequence/description/
public class _LIS_Length {
    class Solution {

        // dp[ind][prevInd+1] = length of LIS starting from index 'ind'
        // where the previously chosen element is at index 'prevInd'
        // We store prevInd+1 because prevInd can be -1 (no previous element)
        int[][] dp;

        public int solve(int[] nums, int ind, int prevInd) {

            // Base case: reached the end of the array
            if (ind == nums.length)
                return 0;

            // If already computed, return stored value
            if (dp[ind][prevInd + 1] != -1)
                return dp[ind][prevInd + 1];

            // Option 1: Do not take current element
            int notTake = solve(nums, ind + 1, prevInd);

            // Option 2: Take current element (only if valid)
            int take = Integer.MIN_VALUE;
            if (prevInd == -1 || nums[ind] > nums[prevInd]) {
                take = 1 + solve(nums, ind + 1, ind);
            }

            // Store and return the best of both choices
            return dp[ind][prevInd + 1] = Math.max(take, notTake);
        }

        public int lengthOfLIS(int[] nums) {
            int n = nums.length;

            // dp size: n x (n+1)
            // prevInd ranges from -1..n-1 → we shift by +1
            dp = new int[n][n + 1];
            for (int i = 0; i < n; i++) {
                Arrays.fill(dp[i], -1);
            }

            // Start from index 0 with no previous element chosen
            return solve(nums, 0, -1);
        }
    }

    //Tabulation
    class Solution {
        public int lengthOfLIS(int[] nums) {
            int n = nums.length;

            // dp[i][j+1] = LIS length starting from index i
            // where the previous chosen index is j
            // j ranges from -1 to n-1, so we shift it by +1
            int[][] dp = new int[n + 1][n + 1];

            // We fill the table from bottom to top
            // i goes from n-1 down to 0
            for (int i = n - 1; i >= 0; i--) {

                // j represents prevInd, which can be from i-1 down to -1
                for (int j = i - 1; j >= -1; j--) {

                    // Option 1: Do not take nums[i]
                    int notTake = dp[i + 1][j + 1];

                    // Option 2: Take nums[i] (only if it is increasing)
                    int take = 0;
                    if (j == -1 || nums[i] > nums[j]) {
                        // If we take nums[i], it becomes the new "previous"
                        take = 1 + dp[i + 1][i + 1];
                    }

                    // Store the best result
                    dp[i][j + 1] = Math.max(take, notTake);
                }
            }

            // Start from index 0 with no previous element (prev = -1 → index 0)
            return dp[0][0];
        }
    }


}
