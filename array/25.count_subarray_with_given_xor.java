class Solution {
    public long subarrayXor(int arr[], int k) {
       Map<Integer, Integer> map = new HashMap<>();
       map.put(0,1);
       int n = arr.length, xor = 0, count = 0;
       for(int i = 0; i< n; i++){
           xor ^= arr[i];
           int diff = xor ^ k;
           if(map.containsKey(diff)){
               count += map.get(diff);
           }
           map.put(xor, map.getOrDefault(xor,0) + 1);
       }
       
       return count;
        
    }
}