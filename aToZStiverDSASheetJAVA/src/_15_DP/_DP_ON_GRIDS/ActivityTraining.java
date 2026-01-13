package aToZStiverDSASheetJAVA.src._15_DP._DP_ON_GRIDS;
//http://geeksforgeeks.org/problems/geeks-training/1
public class ActivityTraining {
    // User function Template for Java
    //Memoization - TC - O(n*4*3) | SC - O(n*4) + O(n) recursion stack
    class Solution {

        // dp[day][last] stores the maximum points we can get
        // till 'day' when the last task performed was 'last'
        int[][] dp;

        public int solve(int[][] arr, int day, int last) {

            // Base case: Day 0
            // Choose the best task on day 0 excluding the 'last' task
            if (day == 0) {
                int maxi = 0;
                for (int i = 0; i < 3; i++) {
                    if (i != last) {
                        maxi = Math.max(maxi, arr[0][i]);
                    }
                }
                return maxi;
            }

            // If already computed, return cached value
            if (dp[day][last] != -1) return dp[day][last];

            int maxi = 0;

            // Try all tasks except the one done on the previous day
            for (int i = 0; i < 3; i++) {
                if (i != last) {
                    int points = arr[day][i] + solve(arr, day - 1, i);
                    maxi = Math.max(maxi, points);
                }
            }

            // Store and return the result
            return dp[day][last] = maxi;
        }

        public int maximumPoints(int arr[][]) {
            int n = arr.length;

            // dp size: n days and 4 states for 'last'
            // (0,1,2 = tasks, 3 = no previous task)
            dp = new int[n][4];
            for (int i = 0; i < n; i++) {
                Arrays.fill(dp[i], -1);
            }

            // Start from last day with 'no previous task'
            return solve(arr, n - 1, 3);
        }
    }
//Tabulation - TC - O(n * 4 * 3) | SC - O(n * 4) → O(n)
    class Solution {

        public int maximumPoints(int arr[][]) {
            int n = arr.length;

            // dp[day][last] -> max points till 'day'
            // when the previous day's task was 'last'
            // last = 0,1,2 (task index), 3 = no previous task
            int[][] dp = new int[n][4];

            // Base case for day 0
            dp[0][0] = Math.max(arr[0][1], arr[0][2]); // if last was 0, choose 1 or 2
            dp[0][1] = Math.max(arr[0][0], arr[0][2]); // if last was 1, choose 0 or 2
            dp[0][2] = Math.max(arr[0][0], arr[0][1]); // if last was 2, choose 0 or 1
            dp[0][3] = Math.max(arr[0][0], Math.max(arr[0][1], arr[0][2])); // no restriction

            // Fill the DP table for remaining days
            for (int day = 1; day < n; day++) {
                for (int last = 0; last < 4; last++) {
                    dp[day][last] = 0;

                    // Try all tasks except the one done on the previous day
                    for (int task = 0; task < 3; task++) {
                        if (task != last) {
                            int points = arr[day][task] + dp[day - 1][task];
                            dp[day][last] = Math.max(dp[day][last], points);
                        }
                    }
                }
            }

            // Answer: last day with no restriction on previous task
            return dp[n - 1][3];
        }
    }


}
