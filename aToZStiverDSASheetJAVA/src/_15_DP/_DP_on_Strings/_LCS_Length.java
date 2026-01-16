package aToZStiverDSASheetJAVA.src._15_DP._DP_on_Strings;
//https://leetcode.com/problems/longest-common-subsequence/
public class _LCS_Length {
    //Memoization
    class Solution {
        // dp[i][j] will store the length of the LCS between:
        // text1[0..i] and text2[0..j]
        int[][] dp;

        public int solve(String s1, String s2, int ind1, int ind2) {

            // Base case:
            // If either string is exhausted, no common subsequence is possible
            if (ind1 < 0 || ind2 < 0) {
                return 0;
            }

            // If this state has already been computed, return it
            if (dp[ind1][ind2] != -1) return dp[ind1][ind2];

            // If current characters match,
            // include this character in LCS and move diagonally
            if (s1.charAt(ind1) == s2.charAt(ind2)) {
                return dp[ind1][ind2] =
                        1 + solve(s1, s2, ind1 - 1, ind2 - 1);
            }

            // If characters do not match, we have two choices:
            // 1) Skip current character from s1
            // 2) Skip current character from s2
            // Take the maximum of both possibilities
            return dp[ind1][ind2] = Math.max(
                    solve(s1, s2, ind1 - 1, ind2),
                    solve(s1, s2, ind1, ind2 - 1)
            );
        }

        public int longestCommonSubsequence(String text1, String text2) {
            int n1 = text1.length();
            int n2 = text2.length();

            // Initialize DP table with -1 to mark uncomputed states
            dp = new int[n1][n2];
            for (int i = 0; i < n1; i++) {
                Arrays.fill(dp[i], -1);
            }

            // Start recursion from the last indices of both strings
            return solve(text1, text2, n1 - 1, n2 - 1);
        }
    }

    //Tabulation

    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            int n1 = text1.length(), n2 = text2.length();

            // dp[i][j] = length of LCS of
            // text1[0..i-1] and text2[0..j-1]
            int[][] dp = new int[n1 + 1][n2 + 1];

            // Build the DP table
            for (int i = 1; i <= n1; i++) {
                for (int j = 1; j <= n2; j++) {

                    // If characters match, extend LCS by 1
                    if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    }
                    // Otherwise, skip one character and take the best
                    else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }

            // LCS length of full strings
            return dp[n1][n2];
        }
    }


}
