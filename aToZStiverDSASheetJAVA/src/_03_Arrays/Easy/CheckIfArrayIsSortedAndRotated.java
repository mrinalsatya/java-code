package aToZStiverDSASheetJAVA.src._03_Arrays.Easy;

public class CheckIfArrayIsSortedAndRotated {
    class Solution {
        public boolean check(int[] nums) {
            int n = nums.length;
            int k =0;
            for(int i =0; i< n; i++){
                if(nums[(i+1)%n] < nums[i]) k++;
                if(k > 1) return false;
            }

            return true;
        }
    }
}
