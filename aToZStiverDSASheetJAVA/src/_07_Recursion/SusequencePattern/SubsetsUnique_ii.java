package aToZStiverDSASheetJAVA.src._07_Recursion.SusequencePattern;

public class SubsetsUnique_ii {
    public void helper(int[] nums, int ind, List<Integer> temp, List<List<Integer>> ans){
        // if(ind == nums.length){
        ans.add(new ArrayList<>(temp));
        // return;
        // }

        for(int i = ind; i<nums.length; i++){
            if(i > ind && nums[i] == nums[i-1]) continue;
            temp.add(nums[i]);
            helper(nums, i+1, temp, ans);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, 0, new ArrayList<Integer>(), ans);
        return ans;
    }
}
