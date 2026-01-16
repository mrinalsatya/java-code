package aToZStiverDSASheetJAVA.src._15_DP._DP_on_Strings;
//https://leetcode.com/problems/longest-palindromic-subsequence/
public class _LPS_Length {
    class Solution {
        public int longestPalindromeSubseq(String s) {
            int n = s.length();

            // Reverse the string
            String rev = new StringBuilder(s).reverse().toString();

            // dp[i][j] = length of LCS between
            // s[0..i-1] and rev[0..j-1]
            int[][] dp = new int[n + 1][n + 1];

            // Build the LCS table
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {

                    // If characters match, extend the subsequence
                    if (s.charAt(i - 1) == rev.charAt(j - 1)) {
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    }
                    // Otherwise, skip one character and take the best
                    else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }

            // The LCS length is the LPS length
            return dp[n][n];
        }
    }

}
