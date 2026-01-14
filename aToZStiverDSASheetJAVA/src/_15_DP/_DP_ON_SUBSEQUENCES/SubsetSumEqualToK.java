package aToZStiverDSASheetJAVA.src._15_DP._DP_ON_SUBSEQUENCES;
//https://www.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1
public class SubsetSumEqualToK {
    //Memoization - TC -  O(n * sum) | SC - O(n * sum)
    class Solution {

        // dp[i][s] stores:
        //  - null  -> not computed yet
        //  - true  -> subset with sum 's' is possible using elements [0..i]
        //  - false -> not possible
        static Boolean[][] dp;

        public static Boolean solve(int[] arr, int ind, int sum) {

            // If required sum becomes 0, we found a valid subset
            if (sum == 0) return true;

            // If only one element is left
            if (ind == 0) return arr[0] == sum;

            // If already computed, return cached result
            if (dp[ind][sum] != null) return dp[ind][sum];

            // Option 1: Do not take the current element
            Boolean notTake = solve(arr, ind - 1, sum);

            // Option 2: Take the current element (only if it does not exceed sum)
            Boolean take = false;
            if (sum >= arr[ind]) {
                take = solve(arr, ind - 1, sum - arr[ind]);
            }

            // Store and return result
            return dp[ind][sum] = take || notTake;
        }

        static Boolean isSubsetSum(int arr[], int sum) {
            int n = arr.length;

            // dp array initialized with null (uncomputed)
            dp = new Boolean[n][sum + 1];

            return solve(arr, n - 1, sum);
        }
    }

    //Tabulation
    static Boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;

        // dp[i][s] = true if we can form sum 's'
        // using elements from index 0 to i
        boolean[][] dp = new boolean[n][sum + 1];

        // Base case: sum 0 is always possible (empty subset)
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        // Base case for first element
        if (arr[0] <= sum) {
            dp[0][arr[0]] = true;
        }

        // Fill the DP table
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= sum; j++) {

                // Option 1: do not take current element
                boolean notTake = dp[i - 1][j];

                // Option 2: take current element (if possible)
                boolean take = false;
                if (j >= arr[i]) {
                    take = dp[i - 1][j - arr[i]];
                }

                // Current state
                dp[i][j] = take || notTake;
            }
        }

        // Final answer: can we form 'sum' using all elements?
        return dp[n - 1][sum];
    }


}
