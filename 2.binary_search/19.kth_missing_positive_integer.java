class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length, low = 0, high = n-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            int missing = arr[mid] - (mid + 1);
            if(missing < k){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        //formula arrived as we are standing at high 
        //so ans will be arr[high] + more
        // we can find more by k - missing 
        //now we put the value of missing here : k - (arr[high] - high - 1)
        // ans = arr[high] + k - arr[high] + high + 1
        //That gives us k + high + 1
        return high + k + 1;
    }
}