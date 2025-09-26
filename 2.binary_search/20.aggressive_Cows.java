class Solution {
    public boolean isPossible(int[] stalls, int k, int d){
        int n = stalls.length, last = stalls[0], cnt = 1;
        for(int i = 1; i<n; i++){
            if(stalls[i] - last >= d){
                cnt++;
                last = stalls[i];
            }
            if(cnt >= k)
                return true;
        }
        return false;
    }
    public int aggressiveCows(int[] stalls, int k) {
        // code here
        Arrays.sort(stalls);
        int n = stalls.length, low = 1, high = stalls[n-1] - stalls[0];
        
        while(low <= high){
            int mid = low + (high-low)/2;
            
            if(isPossible(stalls, k , mid)){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        
        return high;
    }
}