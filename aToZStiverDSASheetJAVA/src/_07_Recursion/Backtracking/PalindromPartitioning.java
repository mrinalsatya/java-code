package aToZStiverDSASheetJAVA.src._07_Recursion.Backtracking;

//https://leetcode.com/problems/palindrome-partitioning/
public class PalindromPartitioning {
    List<List<String>> ans = new ArrayList<>();

    public boolean isPalindrome(String s, int l, int r){


        while(l < r){
            if(s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }

        return true;
    }
    public void helper(int ind, String s, List<String> temp){
        if(ind == s.length()){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i = ind; i < s.length(); i++){
            if(isPalindrome(s, ind, i)){
                temp.add(s.substring(ind, i+1));
                helper(i+1, s, temp);
                temp.remove(temp.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        helper(0, s, new ArrayList());
        return ans;
    }
}
