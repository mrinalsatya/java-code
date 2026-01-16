package aToZStiverDSASheetJAVA.src._15_DP._DP_on_Strings;
//https://leetcode.com/problems/edit-distance/
public class _SM_EditDistance {
    //Memoization
    class Solution {

        // dp[i][j] = minimum operations needed to convert
        // word1[0..i] into word2[0..j]
        int[][] dp;

        public int solve(String s, String t, int i, int j) {

            // Base cases:
            // If s is exhausted, we need to insert (j+1) characters of t
            if (i < 0) return j + 1;

            // If t is exhausted, we need to delete (i+1) characters of s
            if (j < 0) return i + 1;

            // If already computed, return it
            if (dp[i][j] != -1) return dp[i][j];

            // If characters match, no operation is needed
            if (s.charAt(i) == t.charAt(j)) {
                return dp[i][j] = solve(s, t, i - 1, j - 1);
            }

        /*
            Otherwise, try all three operations:

            1) Insert:    insert t[j] into s → move j-1
            2) Delete:    delete s[i]        → move i-1
            3) Replace:   replace s[i]       → move both i-1 and j-1

            Take the minimum of the three and add 1 operation.
        */
            int insert  = solve(s, t, i, j - 1);
            int delete  = solve(s, t, i - 1, j);
            int replace = solve(s, t, i - 1, j - 1);

            return dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
        }

        public int minDistance(String word1, String word2) {
            int n1 = word1.length(), n2 = word2.length();

            // Initialize DP table with -1 (uncomputed states)
            dp = new int[n1][n2];
            for (int i = 0; i < n1; i++) {
                Arrays.fill(dp[i], -1);
            }

            // Start from the last indices of both strings
            return solve(word1, word2, n1 - 1, n2 - 1);
        }
    }
  // tabulation
  class Solution {
      public int minDistance(String s, String t) {
          int n1 = s.length(), n2 = t.length();

          // dp[i][j] = minimum operations to convert
          // s[0..i-1] into t[0..j-1]
          int[][] dp = new int[n1 + 1][n2 + 1];

          // Base cases:
          // Converting empty string to t[0..j-1] -> j insertions
          for (int j = 0; j <= n2; j++) {
              dp[0][j] = j;
          }

          // Converting s[0..i-1] to empty string -> i deletions
          for (int i = 0; i <= n1; i++) {
              dp[i][0] = i;
          }

          // Fill the DP table
          for (int i = 1; i <= n1; i++) {
              for (int j = 1; j <= n2; j++) {

                  // If characters match, no operation needed
                  if (s.charAt(i - 1) == t.charAt(j - 1)) {
                      dp[i][j] = dp[i - 1][j - 1];
                  }
                  // Otherwise, try all three operations
                  else {
                      int insert  = dp[i][j - 1];     // insert t[j-1]
                      int delete  = dp[i - 1][j];     // delete s[i-1]
                      int replace = dp[i - 1][j - 1]; // replace s[i-1] with t[j-1]

                      dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
                  }
              }
          }

          // Minimum operations to convert full s into full t
          return dp[n1][n2];
      }
  }

}
