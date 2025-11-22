package aToZStiverDSASheetJAVA.src._04_BinarySearch.BsOnAnswers;
//https://www.geeksforgeeks.org/problems/aggressive-cows/1
public class AggresiveCows {
    class Solution {
        public static boolean isPossible(int[] stalls, int k, int dis){
            int count = 1, last = stalls[0];
            for(int i = 1; i< stalls.length; i++){
                if(stalls[i] - last >= dis){
                    count++;
                    last = stalls[i];
                }
                if(count >= k) return true;
            }
            return false;
        }
        public int aggressiveCows(int[] stalls, int k) {
            // code here
            Arrays.sort(stalls);
            int n = stalls.length, low = 1, high = stalls[n-1] - stalls[0];
            while(low <= high){
                int mid = low + (high-low)/2;
                if(isPossible(stalls, k, mid)){
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }
            return high;
        }
    }
}
