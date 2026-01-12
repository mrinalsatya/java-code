package aToZStiverDSASheetJAVA.src._15_DP._1D_DP;
//https://leetcode.com/problems/house-robber-ii/submissions/
public class MaxSubSequenceSumCircular {
    class Solution {

        // Solves the linear House Robber problem from index `start` to `end`
        public int solve(int[] nums, int start, int end) {
            int prev1 = 0; // dp[i-1]: max money till previous house
            int prev2 = 0; // dp[i-2]: max money till house before previous

            for (int i = start; i <= end; i++) {
                // Either rob current house (nums[i] + prev2)
                // Or skip it (prev1)
                int curr = Math.max(nums[i] + prev2, prev1);

                // Shift for next iteration
                prev2 = prev1;
                prev1 = curr;
            }

            return prev1;
        }

        public int rob(int[] nums) {
            int n = nums.length;

            // Edge case: only one house
            if (n == 1) return nums[0];

            // Case 1: Rob from 0 to n-2 (exclude last house)
            // Case 2: Rob from 1 to n-1 (exclude first house)
            return Math.max(
                    solve(nums, 0, n - 2),
                    solve(nums, 1, n - 1)
            );
        }
    }

}
