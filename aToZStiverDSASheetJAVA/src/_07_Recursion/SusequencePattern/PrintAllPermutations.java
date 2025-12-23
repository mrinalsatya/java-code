package aToZStiverDSASheetJAVA.src._07_Recursion.SusequencePattern;

//https://leetcode.com/problems/permutations/description/
public class PrintAllPermutations {
    //using extra taken arr - extra space O(n)
    /*
    Time complexity - O(n × n!)
    -Why?
    -Total permutations of n elements = n!
    -For each permutation, copying it into ans takes O(n)
     */
    public void helper(int[] nums, List<Integer> temp, List<List<Integer>> ans, boolean[] taken){
        // Base case:
        // If current permutation size equals nums length,
        // we have formed one complete permutation
        if(temp.size() == nums.length){
            // Add a copy of temp (important!)
            ans.add(new ArrayList<>(temp));
            return;
        }

        // Try picking each element that is not yet used
        for(int i=0; i< nums.length; i++){
            // If this element is already used in current permutation, skip it
            if(!taken[i]){
                // Choose
                taken[i] = true;
                temp.add(nums[i]);
                // Explore (recursive call)
                helper(nums, temp, ans, taken);
                // Un-choose (backtracking step)
                taken[i] = false;
                temp.remove(temp.size()-1);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        // Boolean array to track used indices
        boolean[] taken = new boolean[nums.length];
        helper(nums, new ArrayList<Integer>(), ans, taken);
        return ans;
    }

    // way 2 - swapping | Time complexity - O(n × n!)

    public void helper(int[] nums, int ind, List<List<Integer>> ans){
        // Base case:
        // If we have fixed all positions (0 to ind-1),
        // the current nums[] represents one valid permutation
        if(ind == nums.length){
            // Convert array to List because ans expects List<Integer>
            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                temp.add(nums[i]);
            }
            // Add the permutation to the answer list
            ans.add(new ArrayList<>(temp));
            return;
        }
        // Try placing each element from index 'ind' to end
        // at position 'ind'
        for(int i = ind; i < nums.length; i++){
            // Place nums[i] at index 'ind'
            swap(nums, ind, i);
            // Recurse to fix the next index
            helper(nums, ind+1, ans);
            // Backtrack: restore the array to original state
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
