// User function Template for Java

class Solution {
    public int longestSubarray(int[] arr, int k) {
        // code here
        int n = arr.length;
        int sum = 0;
        int maxLen = 0;
        
        Map<Integer,Integer> mp = new HashMap<>();
        
        for(int i = 0; i< n ;i++){
           sum += arr[i];
           if(sum == k){
               maxLen = Math.max(maxLen, i+1);
           }
            if(mp.containsKey(sum-k)){
                int currLen = i - mp.get(sum-k);
                maxLen = Math.max(maxLen, currLen);
            }
            if(!mp.containsKey(sum))
                mp.put(sum, i);
                
        }
       return maxLen;
        
        
    }
}
