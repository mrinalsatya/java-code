package aToZStiverDSASheetJAVA.src._07_Recursion.SusequencePattern;

//https://leetcode.com/problems/combination-sum/
public class CombinationSum {
    public void helper(int[] nums, int k, int ind, int sum, List<Integer> temp,List<List<Integer>> ans){
        if(sum > k) return;

        if(ind == nums.length){
            if(sum == k) ans.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[ind]);
        helper(nums,k,ind,sum+nums[ind], temp, ans); // since we can reuse the same element we will not increment the index
        temp.remove(temp.size()-1);
        helper(nums, k, ind+1, sum, temp, ans);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(candidates, target, 0, 0, new ArrayList<Integer>(), ans);

        return ans;
    }
}
