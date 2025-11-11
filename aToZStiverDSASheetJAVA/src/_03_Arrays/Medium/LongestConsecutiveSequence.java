package aToZStiverDSASheetJAVA.src._03_Arrays.Medium;

public class LongestConsecutiveSequence {
    class Solution {
        public int longestConsecutive(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for(int num : nums){
                set.add(num);
            }

            int currLen = 0, maxLen = 0, currNum;
            for(int num : set){
                if(!set.contains(num-1)){
                    currLen = 1;
                    currNum = num;
                    while(set.contains(currNum+1)){
                        currLen++;
                        currNum++;
                    }
                    maxLen = Math.max(currLen, maxLen);
                }
            }

            return maxLen;
        }
    }
}
