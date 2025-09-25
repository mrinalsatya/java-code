class Solution {
    public boolean isPossible(int[] piles, int h, int k){
        int n = piles.length, sum = 0;
        for(int i = 0; i< n; i++){
            sum+= Math.ceil((double)piles[i]/k);
            if(sum > h)
                return false;
        }

        return true;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length, high = -1;
        if(n > h)
            return -1;
        for(int i=0; i<n ;i++){
            high = Math.max(high, piles[i]);
        }
        int low = 1, ans = -1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(isPossible(piles, h, mid)){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
}