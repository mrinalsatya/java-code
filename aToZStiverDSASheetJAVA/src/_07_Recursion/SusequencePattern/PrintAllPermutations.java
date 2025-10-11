package aToZStiverDSASheetJAVA.src._07_Recursion.SusequencePattern;

//https://leetcode.com/problems/permutations/description/
public class PrintAllPermutations {
    //using extra taken arr - extra space
    public void helper(int[] nums, List<Integer> temp, List<List<Integer>> ans, boolean[] taken){
        if(temp.size() == nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i=0; i< nums.length; i++){
            if(!taken[i]){
                taken[i] = true;
                temp.add(nums[i]);
                helper(nums, temp, ans, taken);
                taken[i] = false;
                temp.remove(temp.size()-1);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] taken = new boolean[nums.length];
        helper(nums, new ArrayList<Integer>(), ans, taken);
        return ans;
    }

    // way 2 - swapping

    public void helper(int[] nums, int ind, List<List<Integer>> ans){
        if(ind == nums.length){
            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                temp.add(nums[i]);
            }
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i = ind; i < nums.length; i++){
            swap(nums, ind, i);
            helper(nums, ind+1, ans);
            swap(nums, ind, i);
        }
    }

    public void swap(int[] nums, int i, int j){
        int a = nums[i];
        nums[i] = nums[j];
        nums[j] = a;
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums, 0, ans);
        return ans;
    }
}
