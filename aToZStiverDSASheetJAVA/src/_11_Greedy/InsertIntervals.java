package aToZStiverDSASheetJAVA.src._11_Greedy;
//https://leetcode.com/problems/insert-interval/description/
/*
Greedy Intuition (Interview Explanation)
 - The intervals are already sorted
 - We split the work into three phases:
 - Intervals completely before newInterval
 - Intervals overlapping with newInterval
 - Intervals completely after newInterval
Merge overlaps on the fly
Complexity (Optimal) - TC: O(n) | SC: O(n) (for output list)
 */
public class InsertIntervals {
    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {

            int n = intervals.length;

            // Result list to store merged intervals
            List<int[]> ans = new ArrayList<>();

            int i = 0;

            // 1️⃣ Add all intervals that end BEFORE the new interval starts
            while (i < n && intervals[i][1] < newInterval[0]) {
                ans.add(intervals[i]);
                i++;
            }

            // 2️⃣ Merge all overlapping intervals with newInterval
            while (i < n && intervals[i][0] <= newInterval[1]) {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
                i++;
            }

            // Add the merged newInterval
            ans.add(newInterval);

            // 3️⃣ Add all remaining intervals
            while (i < n) {
                ans.add(intervals[i]);
                i++;
            }

            // Convert List<int[]> to int[][]
            return ans.toArray(new int[ans.size()][]);
        }
    }

}
