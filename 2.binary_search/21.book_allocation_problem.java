//same solution for painters partition as well as Split Array Largest Sum


class Solution {
    public boolean isPossible(int[] arr, int k, int pages){
        int sum = 0, st = 1, n = arr.length;
        for(int i = 0; i< n; i++){
            if(arr[i] > pages)
                return false;
            if(sum + arr[i] <= pages){
                sum += arr[i];
            }
            else{
                st++;
                sum = arr[i];
            }
            if(st > k)
                return false;
        }
        return true;
    }
    public int findPages(int[] arr, int k) {
        // code here
        int n = arr.length, low = 0, high = 0, ans = -1;
        if(k > n){
            return -1;
        }
        for(int num : arr){
            low = Math.max(low, num);
            high += num;
        }
        
        while(low <= high){
            int mid = low + (high-low)/2;
            if(isPossible(arr, k, mid)){
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