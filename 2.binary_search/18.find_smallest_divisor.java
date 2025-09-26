class Solution {
    public boolean isPossible(int[] nums, int threshold, int divisor){
        int n = nums.length, sum = 0;
        for(int i = 0; i<n; i++){
            // sum+= Math.ceil((double)nums[i]/divisor); (slower)
            sum += (nums[i] + divisor - 1) / divisor;
            if(sum > threshold)
                return false;
        }

        return true;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length, low = 1, high = -1;
        for(int i = 0; i< n; i++){
            high = Math.max(high, nums[i]);
        }

        while(low <= high){
            int mid = low + (high-low)/2;
            if(isPossible(nums, threshold, mid)){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return low;
    }
}