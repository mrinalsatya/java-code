package aToZStiverDSASheetJAVA.src._15_DP._DP_on_Strings;
//https://leetcode.com/problems/wildcard-matching/description/
public class _SM_WildCardMatching {
    class Solution {

        // dp[i][j] = whether pattern[0..i] matches text[0..j]
        Boolean[][] dp;

        public boolean solve(String pattern, String text, int i, int j) {

            // Case 1: both pattern and text are exhausted
            if (i < 0 && j < 0) return true;

            // Case 2: pattern exhausted but text remains -> no match
            if (i < 0 && j >= 0) return false;

            // Case 3: text exhausted but pattern remains
            // Remaining pattern must be all '*'
            if (i >= 0 && j < 0) {
                for (int k = 0; k <= i; k++) {
                    if (pattern.charAt(k) != '*') return false;
                }
                return true;
            }

            // Memoized result
            if (dp[i][j] != null) return dp[i][j];

            // If characters match OR pattern has '?'
            if (pattern.charAt(i) == text.charAt(j) || pattern.charAt(i) == '?') {
                return dp[i][j] = solve(pattern, text, i - 1, j - 1);
            }

            // If pattern has '*'
            // Two choices:
            // 1) '*' matches empty sequence  -> move pattern (i-1, j)
            // 2) '*' matches one character   -> move text    (i, j-1)
            if (pattern.charAt(i) == '*') {
                return dp[i][j] =
                        solve(pattern, text, i - 1, j)   // '*' as empty
                                || solve(pattern, text, i, j - 1);   // '*' consumes one char
            }

            // Characters don't match
            return dp[i][j] = false;
        }

        public boolean isMatch(String s, String p) {
            int textLen = s.length();
            int patLen = p.length();

            // dp size = pattern length x text length
            dp = new Boolean[patLen][textLen];

            // Start from the end of both strings
            return solve(p, s, patLen - 1, textLen - 1);
        }
    }

    //tabulation
    class Solution {

        public boolean isMatch(String str, String pattern) {
            int strLen = str.length();
            int patLen = pattern.length();

            // dp[i][j] = does str[0..i-1] match pattern[0..j-1]
            boolean[][] dp = new boolean[strLen + 1][patLen + 1];

            // Base case: empty string matches empty pattern
            dp[0][0] = true;

            // Fill first row:
            // Empty string can match pattern only if pattern is all '*'
            for (int j = 1; j <= patLen; j++) {
                if (pattern.charAt(j - 1) == '*') {
                    dp[0][j] = dp[0][j - 1];  // '*' can match empty sequence
                }
            }

            // Fill the DP table
            for (int i = 1; i <= strLen; i++) {
                for (int j = 1; j <= patLen; j++) {

                    // If characters match or pattern has '?'
                    if (pattern.charAt(j - 1) == str.charAt(i - 1)
                            || pattern.charAt(j - 1) == '?') {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                    // If pattern has '*'
                    // '*' can:
                    // 1) match zero characters  -> dp[i][j - 1]
                    // 2) match one/more chars   -> dp[i - 1][j]
                    else if (pattern.charAt(j - 1) == '*') {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                    }
                    // Else: dp[i][j] remains false (no match)
                }
            }

            // Result for full string and full pattern
            return dp[strLen][patLen];
        }
    }


}
