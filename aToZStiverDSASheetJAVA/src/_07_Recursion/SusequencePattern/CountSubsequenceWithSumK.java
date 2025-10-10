package aToZStiverDSASheetJAVA.src._07_Recursion.SusequencePattern;

public class CountSubsequenceWithSumK {
    public int helper(int[] nums, int k, int ind, int sum){
        if(ind >= nums.length){
            if(sum == k) return 1;
            return 0;
        }

        int l = helper(nums, k, ind+1, sum+nums[ind]);

        int r = helper(nums, k, ind+1, sum);

        return l + r;
    }
    public int countSubsequenceWithTargetSum(int[] nums, int k) {
        //your code goes here

        return helper(nums, k, 0, 0);
    }
}
