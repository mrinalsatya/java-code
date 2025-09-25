class Solution {
    public boolean isPossible(int[] weights, int days, int capacity){
        int currWeight = 0, count = 1, n = weights.length;
        for(int i = 0; i < n; i++){
            if(currWeight + weights[i] <= capacity){
                currWeight += weights[i];
            }
            else{
                count++;
                currWeight = weights[i];
                if(count > days){
                    return false;
                }
            }
        }

        return true;
    }
    public int shipWithinDays(int[] weights, int days) {
        int low = -1, high = 0, n = weights.length, ans = -1;
        for(int i = 0; i<n ;i++){
            high+= weights[i];
            low = Math.max(low, weights[i]);
        }
        while(low <= high){
            int mid = low + (high-low)/2;
            if(isPossible(weights, days, mid)){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return ans;
    }
}