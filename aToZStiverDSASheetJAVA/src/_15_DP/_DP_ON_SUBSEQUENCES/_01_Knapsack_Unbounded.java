package aToZStiverDSASheetJAVA.src._15_DP._DP_ON_SUBSEQUENCES;
//https://www.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1
public class _01_Knapsack_Unbounded {
    //Memoization
    class Solution {

        // dp[ind][cap] = maximum value that can be obtained
        // using items from index 0 to ind with remaining capacity 'cap'
        int[][] dp;

        public int solve(int[] val, int[] wt, int cap, int ind) {

        /*
            Base case:
            Only item 0 is available and it can be taken unlimited times.
            So we can take it (cap / wt[0]) times.
        */
            if (ind == 0) {
                return (cap / wt[0]) * val[0];
            }

            // If this state is already computed, return it
            if (dp[ind][cap] != -1) return dp[ind][cap];

            // Option 1: Do not take current item
            int notTake = solve(val, wt, cap, ind - 1);

            // Option 2: Take current item (unbounded, so stay on same index)
            int take = 0;
            if (wt[ind] <= cap) {
                take = val[ind] + solve(val, wt, cap - wt[ind], ind);
            }

            // Store and return the best of both choices
            return dp[ind][cap] = Math.max(take, notTake);
        }

        public int knapSack(int val[], int wt[], int capacity) {
            int n = val.length;

            // Initialize DP table with -1 (uncomputed)
            dp = new int[n][capacity + 1];
            for (int i = 0; i < n; i++) {
                Arrays.fill(dp[i], -1);
            }

            // Start recursion from the last index with full capacity
            return solve(val, wt, capacity, n - 1);
        }
    }

    //Tabulation

    class Solution {

        public int knapSack(int val[], int wt[], int capacity) {
            int n = val.length;

            // dp[i][c] = maximum value achievable
            // using items from index 0 to i with capacity 'c'
            int[][] dp = new int[n][capacity + 1];

        /*
            Base case: only item 0 is available.
            Since this is UNBOUNDED knapsack, we can take item 0
            as many times as possible.

            For any capacity 'c', the best we can do is:
                (c / wt[0]) * val[0]
        */
            for (int c = 0; c <= capacity; c++) {
                dp[0][c] = (c / wt[0]) * val[0];
            }

            // Fill the DP table
            for (int i = 1; i < n; i++) {
                for (int c = 0; c <= capacity; c++) {

                    // Option 1: Do not take the current item
                    int notTake = dp[i - 1][c];

                    // Option 2: Take the current item (unbounded → stay on same row)
                    int take = 0;
                    if (wt[i] <= c) {
                        take = val[i] + dp[i][c - wt[i]];
                    }

                    // Choose the better of the two
                    dp[i][c] = Math.max(take, notTake);
                }
            }

            // Answer: maximum value using all items and full capacity
            return dp[n - 1][capacity];
        }
    }


}
