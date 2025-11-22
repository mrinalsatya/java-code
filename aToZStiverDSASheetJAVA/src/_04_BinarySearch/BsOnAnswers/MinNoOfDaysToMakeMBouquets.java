package aToZStiverDSASheetJAVA.src._04_BinarySearch.BsOnAnswers;
//https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/
public class MinNoOfDaysToMakeMBouquets {
    class Solution {
        public static boolean isPossible(int[] bloomDay, int m, int k, int day){
            int n = bloomDay.length, total = k, sum = 0;
            for(int i = 0; i<n; i++){
                if(bloomDay[i] <= day){
                    total--;
                    if(total == 0){
                        sum++;
                        if(sum >= m)
                            return true;
                        total = k;
                    }
                }else{
                    total = k;
                }
            }

            return false;
        }
        public int minDays(int[] bloomDay, int m, int k) {
            int low = Integer.MAX_VALUE, high = -1, n = bloomDay.length;
            for(int num: bloomDay){
                low = Math.min(low, num);
                high = Math.max(high, num);
            }
            int ans = -1;
            while(low <= high){
                int mid = low+(high-low)/2;
                if(isPossible(bloomDay,m, k, mid)){
                    ans = mid;
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }

            return ans;
        }
    }
}
