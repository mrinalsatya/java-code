package aToZStiverDSASheetJAVA.src._07_Recursion.SusequencePattern;

//https://www.geeksforgeeks.org/problems/subset-sums2234/1
public class SubsetSum_i {
    public void helper(int[] nums, int ind, int sum, ArrayList<Integer> ans){
        if(ind == nums.length){
            ans.add(sum);
            return;
        }

        helper(nums, ind+1, sum + nums[ind], ans);
        helper(nums, ind+1, sum, ans);
    }
    public ArrayList<Integer> subsetSums(int[] arr) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        helper(arr, 0, 0, ans);

        return ans;
    }
}
