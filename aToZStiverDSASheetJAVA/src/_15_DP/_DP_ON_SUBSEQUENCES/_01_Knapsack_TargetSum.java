package aToZStiverDSASheetJAVA.src._15_DP._DP_ON_SUBSEQUENCES;
//https://leetcode.com/problems/target-sum/
public class _01_Knapsack_TargetSum {
    class Solution {

        public int findTargetSumWays(int[] nums, int target) {
            int n = nums.length;
            int sum = 0;

            // Calculate total sum of all elements
            for (int num : nums) sum += num;

        /*
            Let P = sum of numbers with '+' sign
            Let N = sum of numbers with '-' sign

            We have:
                P - N = target
                P + N = sum

            Adding both equations:
                2P = sum + target
                P = (sum + target) / 2

            So the problem reduces to:
            "Count the number of subsets with sum = (sum + target) / 2"
        */

            // If target is not achievable or parity is wrong, return 0
            if (Math.abs(target) > sum || (sum + target) % 2 != 0) return 0;

            int k = (sum + target) / 2;

            // dp[i][s] = number of ways to form sum 's'
            // using elements from index 0 to i
            int[][] dp = new int[n][k + 1];

            // ----- Base Case for the first element -----
            if (nums[0] == 0) {
                // Two ways to make sum 0:
                // +0 and -0
                dp[0][0] = 2;
            } else {
                // One way to make sum 0: empty subset
                dp[0][0] = 1;

                // If nums[0] is within k, we can form that sum by taking it
                if (nums[0] <= k) {
                    dp[0][nums[0]] = 1;
                }
            }

            // ----- Fill the DP table -----
            for (int i = 1; i < n; i++) {
                for (int j = 0; j <= k; j++) {

                    // Option 1: Do not take current element
                    int notTake = dp[i - 1][j];

                    // Option 2: Take current element (if possible)
                    int take = 0;
                    if (nums[i] <= j) {
                        take = dp[i - 1][j - nums[i]];
                    }

                    // Total ways for this state
                    dp[i][j] = take + notTake;
                }
            }

            // Number of ways to reach the target
            return dp[n - 1][k];
        }
    }

}
