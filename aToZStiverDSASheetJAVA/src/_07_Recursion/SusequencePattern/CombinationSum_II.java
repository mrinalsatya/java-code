package aToZStiverDSASheetJAVA.src._07_Recursion.SusequencePattern;

//https://leetcode.com/problems/combination-sum-ii/description/
public class CombinationSum_II {
    public void helper(int[] candidates, int k, int ind, int sum, List<Integer> temp, List<List<Integer>> ans){
        if(sum == k){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i = ind; i < candidates.length; i++){
            if(i > ind && candidates[i] == candidates[i-1]) continue;
            if (sum + candidates[i] > k) break;
            temp.add(candidates[i]);
            helper(candidates, k, i+1, sum + candidates[i], temp, ans);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, 0, 0, new ArrayList<Integer>(), ans);
        return ans;
    }
}
