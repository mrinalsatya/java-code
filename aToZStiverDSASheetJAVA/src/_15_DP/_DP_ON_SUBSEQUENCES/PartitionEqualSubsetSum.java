package aToZStiverDSASheetJAVA.src._15_DP._DP_ON_SUBSEQUENCES;
//https://leetcode.com/problems/partition-equal-subset-sum/description/
//Memoization
public class PartitionEqualSubsetSum {
    class Solution {

        // dp[i][k] =
        //   null  -> not computed yet
        //   true  -> it is possible to form sum 'k' using elements [0..i]
        //   false -> not possible
        Boolean[][] dp;

        public boolean solve(int[] nums, int ind, int k) {

            // If required sum becomes 0, we found a valid subset
            if (k == 0) return true;

            // If only one element is left, it must exactly match k
            if (ind == 0) return nums[0] == k;

            // If already computed, return cached result
            if (dp[ind][k] != null) return dp[ind][k];

            // Option 1: Do not take current element
            boolean notTake = solve(nums, ind - 1, k);

            // Option 2: Take current element (if it does not exceed k)
            boolean take = false;
            if (nums[ind] <= k) {
                take = solve(nums, ind - 1, k - nums[ind]);
            }

            // Store and return result
            return dp[ind][k] = take || notTake;
        }

        public boolean canPartition(int[] nums) {
            int n = nums.length;
            int sum = 0;

            for (int num : nums) {
                sum += num;
            }

            // If total sum is odd, it cannot be split into two equal subsets
            if (sum % 2 != 0) return false;

            int target = sum / 2;

            // Initialize memo table
            dp = new Boolean[n][target + 1];

            // Check if a subset with sum = target exists
            return solve(nums, n - 1, target);
        }
    }

    //Tabulation | Time Complexity: O(n * k) | SC - O(n * k)
    class Solution {

        // Checks if there exists a subset with sum = k
        public boolean solve(int[] nums, int k) {
            int n = nums.length;

            // dp[i][s] = true if we can form sum 's'
            // using elements from index 0 to i
            boolean[][] dp = new boolean[n][k + 1];

            // Base case: sum 0 is always possible (empty subset)
            for (int i = 0; i < n; i++) {
                dp[i][0] = true;
            }

            // Base case for first element
            if (nums[0] <= k) {
                dp[0][nums[0]] = true;
            }

            // Fill the DP table
            for (int i = 1; i < n; i++) {
                for (int j = 1; j <= k; j++) {

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

            // Can we form sum k using all elements?
            return dp[n - 1][k];
        }

        public boolean canPartition(int[] nums) {
            int sum = 0;
            for (int num : nums) sum += num;

            // If total sum is odd, it cannot be split into two equal parts
            if (sum % 2 != 0) return false;

            // Check if subset with sum = sum/2 exists
            return solve(nums, sum / 2);
        }
    }


}
