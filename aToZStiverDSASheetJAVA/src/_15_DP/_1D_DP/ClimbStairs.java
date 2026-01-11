package aToZStiverDSASheetJAVA.src._15_DP._1D_DP;
//https://leetcode.com/problems/climbing-stairs/description/
public class ClimbStairs {
    class Solution {
        int[] dp;  // dp[i] will store number of ways to reach step i

        // Recursive function with memoization
        public int solve(int n) {
            // Base cases:
            // If we are at step 0 or 1, there is exactly 1 way to be there
            if (n == 0 || n == 1) return 1;

            // If already computed, return stored result
            if (dp[n] != -1) return dp[n];

            // Otherwise, compute and store:
            // Ways to reach step n = ways to reach (n-1) + ways to reach (n-2)
            return dp[n] = solve(n - 1) + solve(n - 2);
        }

        public int climbStairs(int n) {
            // Initialize dp array for memoization
            dp = new int[n + 1];
            Arrays.fill(dp, -1);

            // Start solving from step n
            return solve(n);
        }
    }

}
