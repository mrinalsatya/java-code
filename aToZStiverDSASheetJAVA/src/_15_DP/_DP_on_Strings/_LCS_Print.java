package aToZStiverDSASheetJAVA.src._15_DP._DP_on_Strings;

public class _LCS_Print {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();

        // dp[i][j] = length of LCS of
        // text1[0..i-1] and text2[0..j-1]
        int[][] dp = new int[n1 + 1][n2 + 1];

        // Build the DP table
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    // Characters match → extend LCS
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    // Characters don't match → skip one side
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // ---- Reconstruct the LCS string ----
        int i = n1, j = n2;
        StringBuilder sb = new StringBuilder();

        while (i > 0 && j > 0) {
            // If characters match, they are part of LCS
            if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                sb.append(text1.charAt(i - 1));
                i--;
                j--;
            } else {
                // Move in the direction of the larger DP value
                if (dp[i - 1][j] > dp[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }
        }

        // We built the LCS in reverse order
        sb.reverse();
        System.out.println(sb.toString());  // Prints the actual LCS

        // Return the length of LCS
        return dp[n1][n2];
    }

}
