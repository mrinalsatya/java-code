package aToZStiverDSASheetJAVA.src._11_Greedy;
//https://leetcode.com/problems/non-overlapping-intervals/
/*
Greedy Intuition (Interview Explanation)
 - To minimize removals, we must maximize the number of non-overlapping intervals
 - The optimal greedy strategy is:
    👉 Always select the interval with the earliest end time
 - This leaves maximum room for future intervals
This is the same logic as the Activity Selection Problem.
Complexity (Optimal) - TC: O(n log n) (due to sorting) | SC: O(1) (ignoring sort internals)
 */
public class NonOverllapingIntervals {
    class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {

            // Step 1: Sort intervals by their end time (ascending)
            // This allows us to always pick the interval that finishes earliest
            Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

            int n = intervals.length;

            // cnt -> number of non-overlapping intervals selected
            int cnt = 1;

            // endTime -> end time of the last selected interval
            int endTime = intervals[0][1];

            // Step 2: Traverse remaining intervals
            for (int i = 1; i < n; i++) {

                // If current interval does not overlap with the last selected one
                if (intervals[i][0] >= endTime) {
                    cnt++;
                    endTime = intervals[i][1];
                }
            }

            // Step 3: Minimum intervals to remove
            // = total intervals - maximum non-overlapping intervals
            return n - cnt;
        }
    }

}
