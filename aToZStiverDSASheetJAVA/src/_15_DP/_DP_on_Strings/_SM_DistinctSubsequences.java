package aToZStiverDSASheetJAVA.src._15_DP._DP_on_Strings;
//https://leetcode.com/problems/distinct-subsequences/
public class _SM_DistinctSubsequences {
    //memoization
    class Solution {

        // dp[i][j] = number of ways to form t[0..j] from s[0..i]
        int[][] dp;

        public int solve(String s, String t, int i, int j) {

            // If we have matched all characters of t,
            // we found one valid subsequence
            if (j < 0) return 1;

            // If s is exhausted but t is not,
            // no subsequence can be formed
            if (i < 0) return 0;

            // If already computed, return stored result
            if (dp[i][j] != -1) return dp[i][j];

            // If current characters match:
            // 1) Use this match  -> move both i and j
            // 2) Skip s[i]       -> move only i
            if (s.charAt(i) == t.charAt(j)) {
                return dp[i][j] =
                        solve(s, t, i - 1, j)     // skip s[i]
                                + solve(s, t, i - 1, j - 1); // use s[i] to match t[j]
            }

            // If characters don't match, we can only skip s[i]
            return dp[i][j] = solve(s, t, i - 1, j);
        }

        public int numDistinct(String s, String t) {
            int n1 = s.length(), n2 = t.length();

            // dp table of size [n1][n2]
            dp = new int[n1][n2];
            for (int i = 0; i < n1; i++) {
                Arrays.fill(dp[i], -1);
            }

            // Start from the last indices of both strings
            return solve(s, t, n1 - 1, n2 - 1);
        }
    }
 // tabulation

    class Solution {
        public int numDistinct(String s, String t) {
            int n1 = s.length(), n2 = t.length();

            // dp[i][j] = number of ways to form
            // t[0..j-1] from s[0..i-1]
            int[][] dp = new int[n1 + 1][n2 + 1];

            // Base case:
            // An empty string t ("") can always be formed from any prefix of s
            // in exactly 1 way: by deleting all characters.
            for (int i = 0; i <= n1; i++) {
                dp[i][0] = 1;
            }

            // Fill the DP table
            for (int i = 1; i <= n1; i++) {
                for (int j = 1; j <= n2; j++) {

                    // If characters match, we have two choices:
                    // 1) Use s[i-1] to match t[j-1]  -> dp[i-1][j-1]
                    // 2) Skip s[i-1]                 -> dp[i-1][j]
                    if (s.charAt(i - 1) == t.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                    }
                    // If characters don't match, we can only skip s[i-1]
                    else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }

            // Number of ways to form full t from full s
            return dp[n1][n2];
        }
    }

}
