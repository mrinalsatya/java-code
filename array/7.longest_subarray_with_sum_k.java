// User function Template for Java

class Solution {
    public int longestSubarray(int[] arr, int k) {
        // code here
        int n = arr.length;
        Map<Long,Integer> mp = new HashMap<>();
        int currLen = 0, maxLen = 0;
        long prefixSum = 0;
        mp.put(0L,-1);
        for(int i=0; i< n; i++){
            prefixSum += arr[i];
            long diff = prefixSum-k;
            if(mp.containsKey(diff)){
                maxLen = Math.max(maxLen, i - mp.get(diff));
            }
            mp.putIfAbsent(prefixSum, i);
        }
        
        return maxLen;
    }
}
