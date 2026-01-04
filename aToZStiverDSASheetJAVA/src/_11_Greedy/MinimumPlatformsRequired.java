package aToZStiverDSASheetJAVA.src._11_Greedy;
//https://www.geeksforgeeks.org/problems/minimum-platforms-1587115620/1
/*
Greedy Intuition (Interview Explanation)
 - Sort arrival and departure times
 - Traverse them using two pointers
 - Treat arrivals as +1 platform
 - Treat departures as –1 platform
 - Track the maximum platforms used at any point
This simulates a timeline of train events.
Complexity (Optimal) - TC: O(n log n) (sorting dominates) | SC: O(1) (excluding sort internals)
 */
 */
public class MinimumPlatformsRequired {
    class Solution {
        public int minPlatform(int arr[], int dep[]) {

            // Sort arrival times
            Arrays.sort(arr);

            // Sort departure times
            Arrays.sort(dep);

            int n = arr.length;

            // cnt     -> current number of platforms needed
            // maxCnt  -> maximum platforms needed at any time
            int cnt = 0, maxCnt = 0;

            // l -> pointer for arrival array
            // r -> pointer for departure array
            int l = 0, r = 0;

            // Process events in chronological order
            while (l < n && r < n) {

                // If a train arrives before or at the same time
                // another train departs, we need an extra platform
                if (arr[l] <= dep[r]) {
                    cnt++;                          // allocate platform
                    maxCnt = Math.max(maxCnt, cnt);
                    l++;                            // move to next arrival
                }
                // Otherwise, a train departs and frees a platform
                else {
                    cnt--;                          // free platfo

                }
