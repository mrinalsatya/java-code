package aToZStiverDSASheetJAVA.src._03_Arrays.Hard;
//https://leetcode.com/problems/merge-intervals/
public class MergeIntervals {
    class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
            int n = intervals.length;
            int k = 0;
            int[][] ans = new int[n][2];
            ans[0][0] = intervals[0][0];
            ans[0][1] = intervals[0][1];
            for(int i=1; i<n; i++){
                if(ans[k][1] < intervals[i][0]){
                    k++;
                    ans[k][0] = intervals[i][0];
                    ans[k][1] = intervals[i][1];
                }else{
                    ans[k][1] = Math.max(ans[k][1], intervals[i][1]);
                }
            }

            return Arrays.copyOf(ans, k+1);
        }
    }
}
