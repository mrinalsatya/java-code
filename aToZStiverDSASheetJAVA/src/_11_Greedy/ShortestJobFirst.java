package aToZStiverDSASheetJAVA.src._11_Greedy;
//https://www.geeksforgeeks.org/problems/shortest-job-first/1
/*
Key Interview Explanation
- Each process waits for the sum of burst times before it
 - To minimize total waiting time:
 - Execute shorter jobs first
 - Sorting by burst time ensures minimum cumulative waiting
Complexity (Optimal) - TC: O(n log n) (due to sorting) | SC: O(1) (ignoring sort internals)
 */
public class ShortestJobFirst {
    // User function Template for Java

    class Solution {
        static int solve(int bt[]) {

            // Step 1: Sort burst times in ascending order
            // This follows Shortest Job First (SJF) scheduling
            Arrays.sort(bt);

            int time = 0;      // Total time elapsed so far
            int waitTime = 0;  // Sum of waiting times for all processes

            // Step 2: Calculate waiting time
            for (int num : bt) {

                // Current process waits for all previous processes
                waitTime += time;

                // Add current burst time to elapsed time
                time += num;
            }

            // Step 3: Return average waiting time
            return waitTime / bt.length;
        }
    }

}
