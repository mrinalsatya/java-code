class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for(int i=0; i<n; i++){
            set.add(nums[i]);
        }
        int currLen, maxLen = 0, currNum;
        for(int num : set){
             
            if(!set.contains(num-1)){
                currLen = 1;
                currNum = num;
                while(set.contains(currNum+1)){
                    currLen++;
                    currNum++;
                }

                maxLen = Math.max(maxLen, currLen);
            }
        }

        return maxLen;
    }
}