package aToZStiverDSASheetJAVA.src._15_DP._DP_ON_SUBSEQUENCES;
//https://www.geeksforgeeks.org/problems/minimum-sum-partition3317/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card
public class PartitionMinDiff {
    //tabulation
    class Solution {

        public int minimumDifference(int[] nums) {
            int n = nums.length;
            int sum = 0;

            // Calculate total sum
            for (int num : nums) sum += num;

            // dp[i][s] = true if we can form sum 's'
            // using elements from index 0 to i
            boolean[][] dp = new boolean[n][sum + 1];

            // Base case: sum 0 is always possible
            for (int i = 0; i < n; i++) {
                dp[i][0] = true;
            }

            // Base case for first element
            if (nums[0] <= sum) dp[0][nums[0]] = true;

            // Fill the DP table
            for (int i = 1; i < n; i++) {
                for (int j = 1; j <= sum; j++) {

                    // Option 1: do not take current element
                    boolean notTake = dp[i - 1][j];

                    // Option 2: take current element (if possible)
                    boolean take = false;
                    if (nums[i] <= j) {
                        take = dp[i - 1][j - nums[i]];
                    }

                    dp[i][j] = take || notTake;
                }
            }

            // Find the minimum difference between two subset sums
            int mini = Integer.MAX_VALUE;

            // We only need to check sums up to sum/2
            for (int s1 = 0; s1 <= sum / 2; s1++) {
                if (dp[n - 1][s1]) {
                    int s2 = sum - s1;
                    mini = Math.min(mini, Math.abs(s2 - s1));
                }
            }

            return mini;
        }
    }

}
