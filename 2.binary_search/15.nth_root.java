class Solution {
    public int findPow(int k, int n, int m){
        long ans = 1;
        for(int i = 0; i<n;i++){
            ans *= k;
            if(ans > m)
                return 2;
        }
        return ans == m ? 1 : 0;
    }
    public int nthRoot(int n, int m) {
        // code here
        int low = 1, high = m;
        
        while(low <= high){
            int mid = low + (high-low)/2;
            int ans = findPow(mid, n, m);
            if(ans == 1){
                return mid;
            }
            else if(ans == 2){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        
        return -1;
        
    }
}