package aToZStiverDSASheetJAVA.src._07_Recursion.SusequencePattern;
//https://leetcode.com/problems/subsets/description/
public class GenerateAllSubsequence {
    public static void helper(int[] nums, List<List<Integer>> ans,List<Integer> temp, int i){
        if( i >= nums.length){
            ans.add(new ArrayList<>(temp)); // add a copy of temp to ans so future modification of temp does not affect ans;
            return;
        }
        // take the number at ith index
        temp.add(nums[i]);
        helper(nums, ans, temp, i + 1);
        // don't take
        temp.remove(temp.size()-1);
        helper(nums, ans, temp, i + 1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>(); // ans list
        List<Integer> temp = new ArrayList<>(); // temp list
        helper(nums, ans, temp, 0);

        return ans;
    }
}
