package aToZStiverDSASheetJAVA.src._15_DP._DP_on_Strings;
//https://leetcode.com/problems/delete-operation-for-two-strings/description/
public class _LPS_MinDeletionsToMakeAEqualsB {
    class Solution {
        public int minDistance(String word1, String word2) {
            int n1 = word1.length(), n2 = word2.length();

            // dp[i][j] = length of LCS of
            // word1[0..i-1] and word2[0..j-1]
            int[][] dp = new int[n1 + 1][n2 + 1];

            // Build LCS table
            for (int i = 1; i <= n1; i++) {
                for (int j = 1; j <= n2; j++) {

                    // If characters match, extend LCS
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    }
                    // Otherwise, skip one character
                    else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }

            int lcs = dp[n1][n2];

            // Characters not in LCS must be deleted from both strings
            return (n1 - lcs) + (n2 - lcs);
        }
    }

}
