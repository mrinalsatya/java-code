class Solution {
    public boolean isPossible(int[] bloomDay, int m, int k, int day){
        int n = bloomDay.length,count = 0, temp = k;

        for(int i =0; i< n;i++){
            if(bloomDay[i] <= day){
                temp--;
                if(temp == 0){
                    count++;
                    if(count >= m)
                        return true;
                    temp = k;
                }
            }else{
                temp = k;
            }
        }

        return count >= m ? true : false; 

    }
    public int minDays(int[] bloomDay, int m, int k) {
        int low = 1, high = -1, n = bloomDay.length;
        int ans = -1;
        for(int i = 0; i< n; i++){
            high = Math.max(high, bloomDay[i]);
        }
        while(low <= high){
            int mid = low + (high-low)/2;
            if(isPossible(bloomDay, m, k, mid)){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return ans;
    }
}