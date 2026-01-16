package aToZStiverDSASheetJAVA.src._15_DP._DP_on_Strings;
//https://leetcode.com/problems/shortest-common-supersequence/description/
public class _LPS_ShortestCommonSupersequence {
    class Solution {
        public String shortestCommonSupersequence(String word1, String word2) {
            int n1 = word1.length(), n2 = word2.length();

            // dp[i][j] = length of LCS between:
            // word1[0..i-1] and word2[0..j-1]
            int[][] dp = new int[n1 + 1][n2 + 1];

            // Step 1: Build the LCS DP table
            for (int i = 1; i <= n1; i++) {
                for (int j = 1; j <= n2; j++) {
                    // If characters match, extend LCS by 1
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    }
                    // Otherwise, skip one character and take the best
                    else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }

            // Step 2: Reconstruct the Shortest Common Supersequence (SCS)
            StringBuilder ans = new StringBuilder();
            int i = n1, j = n2;

            // Traverse back from dp[n1][n2]
            while (i > 0 && j > 0) {

                // If characters match, include it once in SCS
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    ans.append(word1.charAt(i - 1));
                    i--;
                    j--;
                }
                // Otherwise, move in the direction of larger LCS value
                // and include that character in SCS
                else if (dp[i][j - 1] >= dp[i - 1][j]) {
                    ans.append(word2.charAt(j - 1));
                    j--;
                } else {
                    ans.append(word1.charAt(i - 1));
                    i--;
                }
            }

            // Step 3: Append remaining characters (if any)
            while (i > 0) {
                ans.append(word1.charAt(i - 1));
                i--;
            }
            while (j > 0) {
                ans.append(word2.charAt(j - 1));
                j--;
            }

            // We constructed the SCS from back to front, so reverse it
            return ans.reverse().toString();
        }
    }

}
