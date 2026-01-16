package aToZStiverDSASheetJAVA.src._15_DP._DP_on_Strings;
//https://www.geeksforgeeks.org/problems/longest-common-substring1452/1
public class _LC_Substring {
    // User function Template for Java
    class Solution {

        public int longestCommonSubstr(String s1, String s2) {
            int n1 = s1.length(), n2 = s2.length();

            // dp[i][j] = length of the longest common substring
            // ending at s1[i-1] and s2[j-1]
            int[][] dp = new int[n1 + 1][n2 + 1];

            int ans = 0; // stores the maximum length found

            for (int i = 1; i <= n1; i++) {
                for (int j = 1; j <= n2; j++) {

                    // If characters match, extend the substring
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                        ans = Math.max(ans, dp[i][j]);
                    }
                    // Else case is implicitly 0 (substring breaks)
                    // dp[i][j] = 0;
                }
            }

            // Length of the longest common substring
            return ans;
        }
    }

}
