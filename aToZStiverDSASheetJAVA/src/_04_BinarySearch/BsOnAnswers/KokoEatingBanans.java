package aToZStiverDSASheetJAVA.src._04_BinarySearch.BsOnAnswers;
//https://leetcode.com/problems/koko-eating-bananas/
public class KokoEatingBanans {
    class Solution {
        private static boolean isPossible(int[] piles, int h, int k){
            int ans = 0, n = piles.length;
            for(int i=0; i<n; i++){
                ans+= Math.ceil((double)piles[i]/k);
                if(ans > h) return false;
            }
            return true;
        }
        public int minEatingSpeed(int[] piles, int h) {
            int n = piles.length, high = -1;
            for(int x : piles){
                high = Math.max(x, high);
            }

            int low = 1;

            while(low <= high){
                int mid = low + (high-low)/2;
                if(isPossible(piles, h, mid)){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }

            return low;
        }
    }
}
