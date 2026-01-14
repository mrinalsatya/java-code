package aToZStiverDSASheetJAVA.src._15_DP._DP_ON_SUBSEQUENCES;
//https://www.geeksforgeeks.org/problems/partitions-with-given-difference/1
public class PartitionsWithGivenDiff {
    class Solution {

        public int countPartitions(int[] arr, int diff) {
            int n = arr.length;
            int sum = 0;

            // Calculate total sum of the array
            for (int num : arr) sum += num;

        /*
            Let subset sums be S1 and S2 such that:
                S1 - S2 = diff
                S1 + S2 = sum

            Solving:
                S1 = (sum - diff) / 2

            So the problem reduces to:
            "Count the number of subsets with sum = k",
            where k = (sum - diff) / 2
        */

            // If (sum - diff) is negative or odd, no valid partition exists
            if (sum - diff < 0 || (sum - diff) % 2 != 0) return 0;

            int k = (sum - diff) / 2;

            // dp[i][s] = number of ways to form sum 's'
            // using elements from index 0 to i
            int[][] dp = new int[n][k + 1];

            // ----- Base Case for the first element -----
            if (arr[0] == 0) {
                // Two ways to form sum 0:
                // 1) {}   -> do not take 0
                // 2) {0}  -> take 0
                dp[0][0] = 2;
            } else {
                // One way to form sum 0: empty subset
                dp[0][0] = 1;

                // If arr[0] is within k, we can form that sum by taking it
                if (arr[0] <= k) {
                    dp[0][arr[0]] = 1;
                }
            }

            // ----- Fill the DP table -----
            for (int i = 1; i < n; i++) {
                for (int j = 0; j <= k; j++) {

                    // Option 1: Do not take current element
                    int notTake = dp[i - 1][j];

                    // Option 2: Take current element (if possible)
                    int take = 0;
                    if (arr[i] <= j) {
                        take = dp[i - 1][j - arr[i]];
                    }

                    // Total ways for this state
                    dp[i][j] = take + notTake;
                }
            }

            // dp[n-1][k] gives the number of valid partitions
            return dp[n - 1][k];
        }
    }

}
