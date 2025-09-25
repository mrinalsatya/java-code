class Solution {
    public int mySqrt(int x) {
        int low = 1, high = x;
        while(low<=high){
            int mid = low + (high-low)/2;
            long multiply = (long)mid * mid;
            if(multiply > (long)x){
                high = mid -1;
            }
            else{
                low = mid + 1;
            }
        }

        return high;
    }
}