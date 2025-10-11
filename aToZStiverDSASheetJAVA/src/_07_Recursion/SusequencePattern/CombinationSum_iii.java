package aToZStiverDSASheetJAVA.src._07_Recursion.SusequencePattern;

public class CombinationSum_iii {
    public void helper(int k, int n, int ind, int sum, List<Integer> temp, List<List<Integer>> ans){
        if(temp.size() >= k){
            if(sum == n) ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i = ind; i<= 9; i++){
            if(sum + i > n) break;
            temp.add(i);
            helper(k, n, i+1, sum + i, temp, ans);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(k, n, 1, 0, new ArrayList<>(), ans);
        return ans;
    }
}
