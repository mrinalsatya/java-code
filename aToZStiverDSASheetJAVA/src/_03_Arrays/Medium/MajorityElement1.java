package aToZStiverDSASheetJAVA.src._03_Arrays.Medium;

public class MajorityElement1 {
    class Solution {
        public int majorityElement(int[] nums) {
            int prevNum = nums[0], count = 1;
            int n = nums.length;
            for(int i=1;i<n;i++){
                if(nums[i]==prevNum){
                    count++;
                }
                else{
                    count--;
                    if(count == 0)
                    {
                        prevNum = nums[i];
                        count++;
                    }
                }
            }

            return prevNum;
        }
    }
}
