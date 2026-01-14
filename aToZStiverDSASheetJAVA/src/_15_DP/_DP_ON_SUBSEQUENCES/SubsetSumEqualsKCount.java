package aToZStiverDSASheetJAVA.src._15_DP._DP_ON_SUBSEQUENCES;
//
public class SubsetSumEqualsKCount {
    public class Solution {
       // https://www.geeksforgeeks.org/problems/perfect-sum-problem5633/1
        static int MOD = 1_000_000_007;

        public static int findWays(int num[], int tar) {
            int n = num.length;

            // dp[i][s] = number of ways to form sum 's'
            // using elements from index 0 to i
            long[][] dp = new long[n][tar + 1];

            // ----- Base Case for the first element -----
            // If first element is 0:
            //  - We can form sum 0 in two ways: {} and {0}
            if (num[0] == 0) {
                dp[0][0] = 2;
            } else {
                // Otherwise, empty subset forms sum 0
                dp[0][0] = 1;

                // If num[0] <= target, we can form that sum by taking num[0]
                if (num[0] <= tar) {
                    dp[0][num[0]] = 1;
                }
            }

            // ----- Fill the DP table -----
            for (int i = 1; i < n; i++) {
                for (int j = 0; j <= tar; j++) {

                    // Option 1: Do not take current element
                    long notTaken = dp[i - 1][j];

                    // Option 2: Take current element (if possible)
                    long taken = 0;
                    if (num[i] <= j) {
                        taken = dp[i - 1][j - num[i]];
                    }

                    // Total ways = take + not take
                    dp[i][j] = (notTaken + taken) % MOD;
                }
            }

            // Final answer: number of subsets forming 'tar'
            return (int) dp[n - 1][tar];
        }
    }

}
