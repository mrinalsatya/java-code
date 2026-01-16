package aToZStiverDSASheetJAVA.src._15_DP._DP_on_Strings;
//https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/
public class _LPS_MinInsertionsToMakeStringPalindrome {
    class Solution {
        public int minInsertions(String s1) {

            // Reverse the string
            String s2 = new StringBuffer(s1).reverse().toString();

            // If already a palindrome, no insertions needed
            if (s1.equals(s2)) return 0;

            int n = s1.length();

            // dp[i][j] = LCS length between
            // s1[0..i-1] and s2[0..j-1]
            int[][] dp = new int[n + 1][n + 1];

            // Build LCS table
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {

                    // If characters match, extend subsequence
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    }
                    // Otherwise, skip one character
                    else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }

            // LPS length = dp[n][n]
            // Minimum insertions = n - LPS
            return n - dp[n][n];
        }
    }

}
